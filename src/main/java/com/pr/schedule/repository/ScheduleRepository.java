package com.pr.schedule.repository;


import com.pr.schedule.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

}