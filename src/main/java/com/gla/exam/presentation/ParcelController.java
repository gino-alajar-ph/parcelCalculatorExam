package com.gla.exam.presentation;

import com.gla.exam.core.ParcelFacade;
import com.gla.exam.presentation.dto.ParcelDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/gla")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ParcelController {

    private final ParcelFacade parcelFacade;

    @PostMapping(path = "/parcel", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> calculateParcelCost(@RequestBody ParcelDetailsDto parcelDetailsDto,
                                               @RequestParam(value = "voucher", required = false) String voucher) {

        return ResponseEntity.ok().body(parcelFacade.calculateParcelCost(parcelDetailsDto, voucher));
    }

}
