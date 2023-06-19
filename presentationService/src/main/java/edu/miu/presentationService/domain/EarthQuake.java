package edu.miu.presentationService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarthQuake {
    private String id;
    private Double mg;
    private String state;
    private LocalDateTime time;
    private Coordinate coordinate;

}
