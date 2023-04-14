package com.arabsoft.fidelity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommandRequest {


    private Long id;
    private Float total;
    private Long carteId;
    private List<Long> productsIds;
}
