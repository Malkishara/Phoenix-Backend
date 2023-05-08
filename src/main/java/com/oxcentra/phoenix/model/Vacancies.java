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
@NoArgsConstructor
@Table(name="vacancy")
public class Vacancies implements Serializable {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name="category_id")
    private JobCategory category;

    @ManyToOne
    @JoinColumn(name="type_id")
    private JobTypes type;

    @ManyToOne
    @JoinColumn(name="modality_id")
    private JobModalities modality;

    @Column(name="posted_date")
    private String postedDate;

    @Column(name="salary_range")
    private String salaryRange;

    @Column(name="description")
    private String description;

    @Column(name="description_image")
    private String descriptionImg;

    @Column(name="num_of_request")
    private int numOfRequests;


}
