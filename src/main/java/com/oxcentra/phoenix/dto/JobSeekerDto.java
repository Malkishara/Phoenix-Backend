package com.oxcentra.phoenix.dto;

import com.oxcentra.phoenix.model.Certification;
import com.oxcentra.phoenix.model.Languages;
import com.oxcentra.phoenix.model.Skills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private String profilePicture;
    private String college;
    private String degree;
    private Certification certification;
    private String country;
    private String district;
    private String experience;
    private Languages languages;
    private String linkdin;
    private String position;
    private Skills skills;
}
