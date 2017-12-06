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
    public List<TimeEntry> findAllByOrderByStartedDesc(int limit, int offset) {
        if(limit > 100) {
            // TODO arbitrary for now
            limit = 100;
        }

        if(limit < 1) {
            limit = 1;
        }

        if(offset > 100) {
            // TODO arbitrary for now
            offset = 100;
        }

        if(offset < 0) {
            offset = 0;
        }

        return timeEntryRepository.findAllByOrderByStartedDesc(limit, offset);
    }


    @Override
    public TimeEntry findById(int id) {
        return timeEntryRepository.findById(id);
    }
}
