package com.gla.exam.config;

import com.gla.exam.core.ParcelFacade;
import com.gla.exam.core.service.ParcelService;
import com.gla.exam.core.service.ParcelServiceImpl;
import com.gla.exam.infra.rest.VoucherServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
public class CoreBeansConfiguration {

    @Bean
    ParcelFacade parcelFacade(VoucherServiceClient voucherServiceClient, ParcelService parcelService) {
        return new ParcelFacade(voucherServiceClient, parcelService);
    }

    @Bean
    ParcelService parcelService() {
        return new ParcelServiceImpl();
    }
}
