package com.fittrack.repository;

import com.fittrack.model.entity.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface WorkoutSessionRepository extends  JpaRepository<WorkoutSession, Long> {
}
