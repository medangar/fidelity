package com.arabsoft.fidelity.response;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CarteByClient {

    private int nbMoins18;
    private int nb18et30;
    private int nb30et50;
    private int nbPlus50;
}
