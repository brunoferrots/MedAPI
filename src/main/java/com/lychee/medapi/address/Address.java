package com.lychee.medapi.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String zipcode;
    private String city;
    private String state;
    private String number;
    private String complement;

    public Address(DataAddress dataAddress) {
        this.street = dataAddress.street();
        this.district = dataAddress.district();
        this.zipcode = dataAddress.zipcode();
        this.city = dataAddress.city();
        this.state = dataAddress.state();
        this.number = dataAddress.number();
        this.complement = dataAddress.complement();
    }
}
