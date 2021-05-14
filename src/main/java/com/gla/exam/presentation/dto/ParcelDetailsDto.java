package com.gla.exam.presentation.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class ParcelDetailsDto {

    private Double weight;
    private Double height;
    private Double width;
    private Double length;
}
