package com.gla.exam.core.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public final class ParcelConstants {

    @Getter
    @RequiredArgsConstructor
    public enum Rules {
        REJECT(50, 0),
        HEAVY(10, 20),
        SMALL(1500, 0.03),
        MEDIUM(2500, 0.04),
        LARGE(0, 0.05);
        private final int limit;
        private final double baseAmount;

        public static Rules from(String category) {
            return Arrays.stream(Rules.values())
                    .filter(product -> StringUtils.equalsIgnoreCase(product.name(), category))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No enum constant category." + category));
        }
    }
}
