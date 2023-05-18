package com.lychee.medapi.doctor;

import com.lychee.medapi.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctor(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        DataAddress dataAddress) {

}
