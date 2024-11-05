package com.sw.modulith.biker;

import com.sw.modulith.biker.dto.BikerDto;
import com.sw.modulith.biker.dto.BikerPaymentDto;
import com.sw.modulith.biker.dto.BikerResponseDto;
import com.sw.modulith.biker.type.BikerChallengeStatus;
import com.sw.modulith.challenge.exposed.ChallengeDto;
import com.sw.modulith.challenge.exposed.ChallengeService;
import com.sw.modulith.challenge.exposed.ChallengeLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BikerService {
    private final ChallengeService challengeService;
    private final BikerRepository bikerRepository;
    private final BikerChallengeRepository bikerChallengeRepository;
    private final BikerEventService bikerEventService;

    public BikerResponseDto createBiker(BikerDto bikerDto){

        List<ChallengeDto> challenges = challengeService.fetchAllByChallengeLevel(ChallengeLevel.MEDIUM);

        Biker biker = buildAndPersistBiker(bikerDto);
        log.info("Biker created: {}", biker);

        buildAndPersistBikerChallenges(biker, challenges);

        BikerPaymentDto bikerPaymentDto = new BikerPaymentDto(UUID.randomUUID().toString(), 0D);
        bikerEventService.completeBiker(bikerPaymentDto);

        return new BikerResponseDto("Challenges currently processed", 200);

    }

    private void buildAndPersistBikerChallenges(Biker biker, List<ChallengeDto> challenges) {
        List<BikerChallenge> bikerChallenges = new ArrayList<>(challenges.size());

        challenges.forEach( challengeDto -> {
            BikerChallenge bikerChallenge = new BikerChallenge();
            bikerChallenge.setChallengeId(challengeDto.id());
            bikerChallenge.setBikerId(biker.getId());
            bikerChallenge.setBikerChallengeStatus(BikerChallengeStatus.NOT_COMPLETED);
            bikerChallenge.setCreationDate(new Timestamp(System.currentTimeMillis()));
            bikerChallenge.setCreditNumber(70L);
            bikerChallenges.add(bikerChallenge);
        });
        bikerChallengeRepository.saveAll(bikerChallenges);
        log.info("Biker challenges persisted: {}", bikerChallenges);

    }

    private Biker buildAndPersistBiker(BikerDto bikerDto) {
        Biker biker = new Biker();
        biker.setBirthdate(bikerDto.birthdate());
        biker.setName(bikerDto.name());
        biker.setPiun(bikerDto.piun());
        return bikerRepository.save(biker);
    }
}
