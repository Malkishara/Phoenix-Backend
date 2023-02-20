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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="company")
public class Companies implements Serializable {


    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;



}
