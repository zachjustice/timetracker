package com.zach.timetracker.service;

import com.zach.timetracker.domain.TimeEntry;

import java.util.List;

public interface TimeEntryService {
    void deleteById(Integer id);
    TimeEntry save(TimeEntry timeEntry);
    List<TimeEntry> findAll();
    List<TimeEntry> findAllByOrderByStartedDesc();
    TimeEntry findById(int id);
}
