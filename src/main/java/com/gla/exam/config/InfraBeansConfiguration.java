package com.gla.exam.config;

import com.gla.exam.infra.rest.VoucherServiceFeignClient;
import com.gla.exam.infra.rest.VoucherRestClient;
import com.gla.exam.infra.rest.VoucherServiceClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableFeignClients("com.gla.exam.infra.rest")
@Primary
public class InfraBeansConfiguration {

    @Bean
    VoucherServiceClient voucherRestClient(VoucherServiceFeignClient voucherServiceFeignClient) {
        return new VoucherRestClient(voucherServiceFeignClient);
    }
}
