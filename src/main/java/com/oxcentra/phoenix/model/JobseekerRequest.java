package com.oxcentra.phoenix.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="request")
public class JobseekerRequest {
    @Id
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="vacancy")
    private Vacancies vacancy;

    @ManyToOne
    @JoinColumn(name="job_seeker")
    private JobSeeker jobSeeker;
}
