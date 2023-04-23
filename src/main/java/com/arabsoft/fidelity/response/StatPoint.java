package com.arabsoft.fidelity.response;

import lombok.*;
import org.hibernate.collection.spi.PersistentList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class StatPoint {

    private List<String> mois = new ArrayList<>();
    private List<Integer> pointConsommer= new ArrayList<>();
    private List<Integer> pointCumuler= new ArrayList<>();
}
