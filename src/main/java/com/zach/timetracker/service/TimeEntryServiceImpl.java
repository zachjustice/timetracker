package com.zach.timetracker.service;

import com.zach.timetracker.domain.TimeEntry;
import com.zach.timetracker.repository.TimeEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("timeEntryService")
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryServiceImpl(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public TimeEntry saveTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public List<TimeEntry> findAll() {
        return timeEntryRepository.findAll();
    }

    @Override
    public TimeEntry findById(int id) {
        return timeEntryRepository.findById(id);
    }
}
