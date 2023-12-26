package com.masudbappy.notifications.repository;

import com.masudbappy.notifications.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
