package com.lychee.medapi.controller;

import com.lychee.medapi.doctor.DataDoctor;
import com.lychee.medapi.doctor.DataListDoctor;
import com.lychee.medapi.doctor.Doctor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataDoctor data) {
        repository.save(new Doctor(data));
    }
    @GetMapping
    public Page<DataListDoctor> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(DataListDoctor::new);
    }
}
