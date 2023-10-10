package com.karaca.customertrackingsystem.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateCustomerRequest {
    private String username;
    private String lastname;
    private String email;
    private String mobilePhone;
    private String gender;
    private Date dateBirthday;
    private String address;
}
