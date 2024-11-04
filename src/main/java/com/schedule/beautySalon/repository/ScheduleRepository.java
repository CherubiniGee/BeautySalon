package com.schedule.beautySalon.repository;

import com.schedule.beautySalon.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByScheduledDate(LocalDate scheduledDate);
}
