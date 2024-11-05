package com.sw.modulith.biker;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BikerChallengeRepository extends CrudRepository<BikerChallenge, Long> {

    @Query(nativeQuery = true, value = "SELECT SUM(bc.credit_number) FROM biker_challenge bc WHERE bc.biker_id = ?1")
    Long totalCredits(Long bikerId);
}
