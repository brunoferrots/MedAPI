package com.lychee.medapi.doctor;

import com.lychee.medapi.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public class Doctor {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;

    private boolean active;

    public Doctor(DataDoctor doctor) {
        this.name = doctor.name();
        this.email = doctor.email();
        this.crm = doctor.crm();
        this.specialty = doctor.specialty();
        this.address = new Address(doctor.address());
        this.phoneNumber = doctor.phoneNumber();
        this.active = true;
    }

    public void updateInformation(DataUpdateDoctor data) {
        if(data.name() != null)
            this.name = data.name();

        if(data.phoneNumber() != null)
            this.phoneNumber = data.phoneNumber();

        if (data.dataAddress() != null)
            this.address.updateAddress(data.dataAddress());
    }

    public void disable() {
        this.active = false;
    }
}
