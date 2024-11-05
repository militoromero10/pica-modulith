package com.sw.modulith.biker;

import com.sw.modulith.biker.type.BikerChallengeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "biker_challenge", indexes = {
        @Index(name = "biker_idx", columnList = "biker_id"),
        @Index(name = "challenge_idx", columnList = "challenge_id")
})
public class BikerChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bikerId;
    private Long challengeId;
    private Long creditNumber;
    private BikerChallengeStatus bikerChallengeStatus;
    private Timestamp creationDate;
}
