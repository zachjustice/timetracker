package com.zach.timetracker.service;

import com.zach.timetracker.domain.TimeEntry;

import java.util.List;

public interface TimeEntryService {
    TimeEntry saveTimeEntry(TimeEntry timeEntry);
    List<TimeEntry> findAll();
    TimeEntry findById(int id);
}
