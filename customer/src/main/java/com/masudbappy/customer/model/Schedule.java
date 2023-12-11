package com.masudbappy.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Schedule {
    @Id()
    private int staffId;
    private Date startTime;
    private Date endTime;
    private boolean isDayOff;
}
