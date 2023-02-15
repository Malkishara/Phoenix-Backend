package com.oxcentra.phoenix.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="types")
@Data
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class JobTypes implements Serializable {
    public JobTypes(){}

    @Id
    @Column(name="id")
    private String typeId;

    @Column(name="title")
    private String typeTitle;
}
