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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
public class JobCategory implements Serializable {


    @Id
    @Column(name="id")
    private String id;

    @Column(name="title")
    private String title;


}
