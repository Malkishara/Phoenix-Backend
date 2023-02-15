package com.oxcentra.phoenix.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@Table(name="company")
public class Companies implements Serializable {

    public Companies(){}

    @Id
    @Column(name="id")
    private String companyId;

    @Column(name="name")
    private String companyName;

    @Column(name="address")
    private String companyAddress;

    @OneToMany
    @JoinColumn(name="id")
    private Set<Vacancies> vacancies;


}
