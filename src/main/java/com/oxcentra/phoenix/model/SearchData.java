package com.oxcentra.phoenix.model;

import lombok.*;

import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchData {

    private String category_id;
    private Type[] type;
    private Modality[] modality;
    private SearchText[] search_text;
}
