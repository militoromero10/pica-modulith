package com.sw.modulith.challenge;

import com.sw.modulith.challenge.exposed.ChallengeLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    Optional<Challenge> getChallengeByName(String name);
    List<Challenge> getAllByChallengeLevel(ChallengeLevel cl);
}
