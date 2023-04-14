package com.arabsoft.fidelity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsePointRequest {

    private Long carteId;

    private Float nbPoint;
}
