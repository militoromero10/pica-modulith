package com.sw.modulith.biker.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BikerChallengeStatus {
    COMPLETED("C"), NOT_COMPLETED("NC");

    private final String code;

}
