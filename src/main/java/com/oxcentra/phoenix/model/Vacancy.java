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
    private Integer id;

    @Column(name="title")
    private String title;

    @JoinColumn(name="category_id")
    private String category;

    @JoinColumn(name="type_id")
    private String type;

    @JoinColumn(name="modality_id")
    private String modality;

    @Column(name="salary_range")
    private String salaryRange;

    @Column(name="description")
    private String description;

}
