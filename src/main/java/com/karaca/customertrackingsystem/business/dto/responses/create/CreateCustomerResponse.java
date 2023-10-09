package com.karaca.customertrackingsystem.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerResponse {
    private int id;
    private String username;
    private String lastname;
    private String email;
    private String mobilePhone;
    private boolean gender;
    private Date dateBirthday;
    private String address;
    private LocalDateTime dateCreated;
}
