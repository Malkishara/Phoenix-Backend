package com.oxcentra.phoenix.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="company")
@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
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
