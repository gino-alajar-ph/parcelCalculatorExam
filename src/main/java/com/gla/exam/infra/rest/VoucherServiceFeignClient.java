package com.gla.exam.infra.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "voucherServiceClient", url = "${rest-url.voucher-service}")
@RequestMapping
public interface VoucherServiceFeignClient {

    @GetMapping("/{code}")
    VoucherServiceClient.VoucherDto getVoucherDetails(@PathVariable("code") String code,
                                                      @RequestParam("key") String key);
}
