package com.oxcentra.phoenix.dto;

import lombok.*;


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
