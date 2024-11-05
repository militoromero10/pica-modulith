package com.sw.modulith.challenge.exposed;

import java.util.List;

public interface ChallengeService {
    ChallengeDto fetchChallengeByName(String name);
    List<ChallengeDto> fetchAllByChallengeLevel(ChallengeLevel cl);
}
