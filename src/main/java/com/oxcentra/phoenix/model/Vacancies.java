package com.oxcentra.phoenix.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@Table(name="vacancies")
public class Vacancies implements Serializable {

    public Vacancies(){}

    @Id
    @Column(name="id")
    private Integer vacancyId;

    @Column(name="title")
    private String vacancyTitle;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Companies company;

    @Column(name="category_id")
    private String catID;

    @Column(name="modality_id")
    private String modId;

    @Column(name="posted_date")
    private String postedDate;

    @Column(name="salary_range")
    private String salary;

    @Column(name="description")
    private String description;


    private String jobType;

}
