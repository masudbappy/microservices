package com.masudbappy.customer.repository;

import com.masudbappy.customer.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SchedularRepository extends JpaRepository<Schedule, Integer> {
    Schedule findByStartTime(Date startTime);
    @Query(value = "select s from Schedule s where s.staffId=?1")
    Schedule abcd(int staffId);
}
