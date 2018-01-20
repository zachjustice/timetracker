package com.zach.timetracker.service;

import com.zach.timetracker.domain.TimeEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TimeEntryService {
    void deleteById(Integer id);
    TimeEntry save(TimeEntry timeEntry);
    List<TimeEntry> findAll();
    Page<TimeEntry> findAllByOrderByStartedDesc(Pageable page);
    TimeEntry findById(int id);
}
