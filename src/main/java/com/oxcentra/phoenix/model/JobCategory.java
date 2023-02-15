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
@Table(name="category")
public class JobCategory implements Serializable {

    public JobCategory(){}

    @Id
    @Column(name="id")
    private String categoryId;

    @Column(name="title")
    private String categoryTitle;


}
