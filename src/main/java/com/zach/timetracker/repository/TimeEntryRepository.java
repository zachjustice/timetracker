package com.zach.timetracker.repository;

import com.zach.timetracker.domain.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository  extends JpaRepository<TimeEntry, Long> {
    @Override
    List<TimeEntry> findAll();
    TimeEntry findById(int id);
}
