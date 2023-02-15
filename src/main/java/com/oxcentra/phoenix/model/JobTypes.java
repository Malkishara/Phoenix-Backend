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
@Table(name="types")
public class JobTypes implements Serializable {
    public JobTypes(){}

    @Id
    @Column(name="id")
    private String typeId;

    @Column(name="title")
    private String typeTitle;
}
