package com.gla.exam.core;

import com.gla.exam.core.service.ParcelService;
import com.gla.exam.infra.rest.VoucherServiceClient;
import com.gla.exam.presentation.dto.ParcelDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
public class ParcelFacade {

    private static final String API_KEY = "apikey";
    private final VoucherServiceClient voucherServiceClient;
    private final ParcelService parcelService;

    public Double calculateParcelCost(ParcelDetailsDto parcelDetailsDto, String voucher) {

        double discount = 0.0;

        if (!Objects.isNull(voucher) && !StringUtils.isEmpty(voucher)) {
            discount = getDiscount(voucher);
        }

        double cost = parcelService.computeCost(parcelDetailsDto);

        if (discount != 0.0) {
            cost = computeDiscountedAmount(cost, discount);
        }

        return cost;
    }

    private Double getDiscount(String voucher) {

        VoucherServiceClient.VoucherDto dto = voucherServiceClient.getVoucherDetails(voucher, API_KEY);
        return dto.getDiscount();
    }

    private Double computeDiscountedAmount(double cost, double discount) {

        Double discountedAmount = cost - ((cost * discount) / 100);
        return discountedAmount;
    }
}
