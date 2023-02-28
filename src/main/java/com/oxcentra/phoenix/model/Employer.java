package com.oxcentra.phoenix.model;

import lombok.*;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="company")
public class Employer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="logo")
    private String logo;

    @Column(name="password")
    private String password;

}
