package com.sw.modulith.challenge;

import com.sw.modulith.challenge.exposed.ChallengeDto;
import com.sw.modulith.challenge.exposed.ChallengeService;
import com.sw.modulith.challenge.exposed.ChallengeLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;
    private final Mapper<Challenge, ChallengeDto> challengeMapper;

    @Override
    public ChallengeDto fetchChallengeByName(String name) {
        return challengeRepository.getChallengeByName(name)
                .map(challengeMapper::map)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Could not find challenge by name: %s", name)));
    }

    @Override
    public List<ChallengeDto> fetchAllByChallengeLevel(ChallengeLevel cl) {
        return challengeRepository.getAllByChallengeLevel(cl)
                .stream()
                .map(challengeMapper::map)
                .toList();
    }
}
