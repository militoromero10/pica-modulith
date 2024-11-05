package com.sw.modulith.challenge;

import com.sw.modulith.challenge.exposed.ChallengeLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "challenge")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ChallengeLevel challengeLevel;
    private String description;

}
