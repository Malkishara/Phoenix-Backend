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
@Table(name="skill")
public class Skills {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="skill")
    private String skill;
//
//    @ManyToOne
//    @JoinColumn(name="jobseeker_id")
//    private JobSeeker jobSeeker;
}
