package com.gla.exam.core.service;

import com.gla.exam.core.exception.RejectException;
import com.gla.exam.presentation.dto.ParcelDetailsDto;

public interface ParcelService {

    Double computeCost(ParcelDetailsDto parcelDetailsDto);
}
