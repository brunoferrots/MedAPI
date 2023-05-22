package com.lychee.medapi.controller;

import com.lychee.medapi.doctor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public ResponseEntity<Page<DataListDoctor>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DataListDoctor::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInformation(data);
        return ResponseEntity.ok(new DataDetailDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.disable();
        return ResponseEntity.noContent().build();
    }

}
