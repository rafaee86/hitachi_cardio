package com.hitachiebwork.cardiochallenges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitachiebwork.cardiochallenges.model.ChallengeLevel;

@Repository
public interface ChallengesLevelRepository extends JpaRepository<ChallengeLevel, Long> {

}
