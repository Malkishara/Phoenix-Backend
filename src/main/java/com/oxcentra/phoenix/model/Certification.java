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
@Table(name="certification")
public class Certification {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="certification")
    private String certification;

//    @ManyToOne
//    @JoinColumn(name="jobseeker_id")
//    private JobSeeker jobSeeker;
}
