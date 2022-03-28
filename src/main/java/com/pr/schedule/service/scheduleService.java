package com.pr.schedule.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.pr.schedule.model.Schedule;
import com.pr.schedule.repository.ScheduleRepository;

import java.util.List;

@Service
@Transactional
public class scheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    public List<Schedule> listAllSchedules() {
        return scheduleRepository.findAll();
    }

    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public Schedule getSchedule(Integer id) {
        return scheduleRepository.findById(id).get();
    }

    public void deleteSchedule(Integer id) {
        scheduleRepository.deleteById(id);
    }

}