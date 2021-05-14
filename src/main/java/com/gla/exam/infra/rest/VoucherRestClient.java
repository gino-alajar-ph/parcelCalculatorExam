package com.gla.exam.infra.rest;

import com.gla.exam.core.exception.VoucherException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class VoucherRestClient implements VoucherServiceClient {

    private VoucherServiceFeignClient voucherServiceFeignClient;

    @Override
    public VoucherDto getVoucherDetails(String code, String key) {

        VoucherDto voucherDto = new VoucherDto();

        try {
            voucherDto = voucherServiceFeignClient.getVoucherDetails(code, key);
        } catch (Exception exception) {
            throw new VoucherException("Invalid voucher code");
        }
        return voucherDto;
    }
}
