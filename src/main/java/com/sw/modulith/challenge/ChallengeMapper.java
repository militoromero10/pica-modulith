package com.sw.modulith.challenge;

import com.sw.modulith.challenge.exposed.ChallengeDto;
import org.springframework.stereotype.Component;

@Component
public class ChallengeMapper implements Mapper<Challenge, ChallengeDto> {
    @Override
    public ChallengeDto map(Challenge challenge) {
        return new ChallengeDto(challenge.getId(), challenge.getName(), challenge.getChallengeLevel(), challenge.getDescription());
    }
}
