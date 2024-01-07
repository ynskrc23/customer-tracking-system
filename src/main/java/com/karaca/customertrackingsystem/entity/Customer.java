package com.karaca.customertrackingsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.karaca.customertrackingsystem.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    private String mobilePhone;

    @Enumerated(EnumType.STRING)
    private Gender gender; //  Female, Male

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateBirthday;

    @Column(columnDefinition = "TEXT")
    private String address;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @OneToOne(mappedBy = "customer")
    private Order order;
}
