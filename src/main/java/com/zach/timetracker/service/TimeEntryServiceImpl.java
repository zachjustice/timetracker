package com.zach.timetracker.service;

import com.zach.timetracker.domain.TimeEntry;
import com.zach.timetracker.repository.TimeEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("timeEntryService")
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryServiceImpl(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public TimeEntry save(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    @Transactional
    public void deleteById(Integer id) {
        timeEntryRepository.deleteById(id);
    }

    @Override
    public List<TimeEntry> findAll() {
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> findAllByOrderByStartedDesc() {
        return timeEntryRepository.findAllByOrderByStartedDesc();
    }


    @Override
    public TimeEntry findById(int id) {
        return timeEntryRepository.findById(id);
    }
}
