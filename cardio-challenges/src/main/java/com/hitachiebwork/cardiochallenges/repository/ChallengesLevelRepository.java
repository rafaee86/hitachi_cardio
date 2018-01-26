/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebwork.cardiochallenges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitachiebwork.cardiochallenges.model.ChallengeLevel;

@Repository
public interface ChallengesLevelRepository extends JpaRepository<ChallengeLevel, Long> {

}
