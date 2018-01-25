package com.hitachiebwork.cardiochallenges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitachiebwork.cardiochallenges.model.Challenges;

@Repository
public interface ChallengesRepository extends JpaRepository<Challenges, Long> {

	public List<Challenges> findByDescriptionLikeIgnoreCase(String description);
	public List<Challenges> findByLevelPkid(Long pkid);
}
