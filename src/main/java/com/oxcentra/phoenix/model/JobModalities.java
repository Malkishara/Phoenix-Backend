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
@Table(name="modality")
public class JobModalities implements Serializable {
    public JobModalities(){}

    @Id
    @Column(name="id")
    private String modalityId;

    @Column(name="title")
    private String modalityTitle;
}
