package com.gla.exam.core.service;

import com.gla.exam.core.util.MeasurementCalculatorUtility;
import com.gla.exam.core.util.ParcelConstants;
import com.gla.exam.core.exception.RejectException;
import com.gla.exam.core.util.AmountCalculatorUtil;
import com.gla.exam.presentation.dto.ParcelDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    @Override
    public Double computeCost(ParcelDetailsDto dto) {

        Double volume = MeasurementCalculatorUtility.volume(dto.getHeight(), dto.getWidth(), dto.getLength());

        Double cost = 0.0;
        if (dto.getWeight() > ParcelConstants.Rules.REJECT.getLimit()) {
            throw new RejectException("Weight is beyond 50kg limit");

        } else if (dto.getWeight() > ParcelConstants.Rules.HEAVY.getLimit()
                && dto.getWeight() < ParcelConstants.Rules.REJECT.getLimit()) {
            cost = AmountCalculatorUtil.computeAmount(ParcelConstants.Rules.HEAVY.getBaseAmount(), dto.getWeight());

        } else if (volume < ParcelConstants.Rules.SMALL.getLimit()) {
            cost = AmountCalculatorUtil.computeAmount(ParcelConstants.Rules.SMALL.getBaseAmount(), volume);

        } else if (volume < ParcelConstants.Rules.MEDIUM.getLimit()) {
            cost = AmountCalculatorUtil.computeAmount(ParcelConstants.Rules.MEDIUM.getBaseAmount(), volume);

        } else {
            cost = AmountCalculatorUtil.computeAmount(ParcelConstants.Rules.LARGE.getBaseAmount(), volume);
        }

        return cost;
    }
}
