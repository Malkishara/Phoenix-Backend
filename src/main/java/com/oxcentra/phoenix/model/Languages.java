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
@Table(name="language")
public class Languages {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="language")
    private String language;

//    @Column(name="select")
//    private Boolean select;

//    @ManyToOne
//    @JoinColumn(name="jobseeker_id")
//    private JobSeeker jobSeeker;
}
