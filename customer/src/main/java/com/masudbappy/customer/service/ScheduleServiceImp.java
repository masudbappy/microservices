package com.masudbappy.customer.service;

import com.masudbappy.customer.model.Schedule;
import com.masudbappy.customer.repository.SchedularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ScheduleServiceImp implements ScheduleService{

    private SchedularRepository schedularRepository;

    @Autowired
    public ScheduleServiceImp(SchedularRepository schedularRepository) {
        this.schedularRepository = schedularRepository;
    }

    @Override
    @Transactional
    public Schedule saveScheduleData(Schedule schedule) {
        schedularRepository.findById(schedule.getStaffId());
        schedularRepository.findByStartTime(schedule.getStartTime());
        return schedularRepository.save(schedule);
    }
}
