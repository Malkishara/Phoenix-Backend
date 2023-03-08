package com.oxcentra.phoenix.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String cv;
    private String password;
    private String confirmPassword;
}
