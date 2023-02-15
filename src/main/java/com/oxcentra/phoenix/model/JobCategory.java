package com.oxcentra.phoenix.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="category")
@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class JobCategory implements Serializable {

    public JobCategory(){}

    @Id
    @Column(name="id")
    private String categoryId;

    @Column(name="title")
    private String categoryTitle;


}
