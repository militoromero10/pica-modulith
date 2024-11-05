package com.sw.modulith.challenge.exposed;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChallengeLevel {
    EASY("E"), MEDIUM("M"), HARD("H");

    private final String code;
}
