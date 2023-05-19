package com.oxcentra.phoenix.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seeker")
public class JobSeeker {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="cv")
    private String cv;

    @Column(name="password")
    private String password;

    @Column(name="profile_picture")
    private String profilePicture;


    @Column(name="college")
    private String college;

    @Column(name="degree")
    private String degree;

    @OneToMany(cascade=CascadeType.ALL, targetEntity=Certification.class)
    @JoinColumn(name="jobseeker_id")
    private List<Certification> certification;

    @Column(name="country")
    private String country;

    @Column(name="district")
    private String district;

    @Column(name="experience")
    private String experience;

    @OneToMany(cascade=CascadeType.ALL, targetEntity=Languages.class)
    @JoinColumn(name="jobseeker_id")
    private List<Languages> languages;

    @Column(name="linkdin")
    private String linkdin;

    @Column(name="position")
    private String position;

    @OneToMany(cascade=CascadeType.ALL, targetEntity=Skills.class)
    @JoinColumn(name="jobseeker_id")
    private List<Skills> skills;

    @OneToMany(cascade=CascadeType.ALL, targetEntity=CertificateImage.class)
    @JoinColumn(name="jobseeker_id")
    private List<CertificateImage> certificate;


    public JobSeeker(int id, String firstName, String lastName, String phone, String email, String cv, String password, String profilePicture, String district, String country, String college, String degree, Certification certification, Skills skills, Languages languages, String position, String experience, String linkdin,CertificateImage certificateImage) {
    }
}
