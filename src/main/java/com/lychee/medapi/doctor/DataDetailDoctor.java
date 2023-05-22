package com.lychee.medapi.doctor;

import com.lychee.medapi.address.Address;

public record DataDetailDoctor(Long id, String name, String email, String crm, String phoneNumber, Address address) {
    public DataDetailDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhoneNumber(), doctor.getAddress());
    }
}
