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
@Table(name="vacancy")
public class Vacancy {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;


    @Column(name="company_id")
    private Integer employer;

    @Column(name="category_id")
    private String category;


    @Column(name="type_id")
    private String type;


    @Column(name="modality_id")
    private String modality;

    @Column(name="salary_range")
    private String salaryRange;

    @Column(name="description")
    private String description;

    @Column(name="description_image")
    private String descriptionImg;
}
