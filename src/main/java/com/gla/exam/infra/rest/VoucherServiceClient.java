package com.gla.exam.infra.rest;

import lombok.*;

import java.time.LocalDate;

public interface VoucherServiceClient {

    VoucherDto getVoucherDetails(String code, String key);

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @ToString
    class VoucherDto {
        private String code;
        private Double discount;
        private LocalDate expiry;
    }
}
