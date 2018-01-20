package com.zach.timetracker.repository;

import com.zach.timetracker.domain.TimeEntry;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository  extends PagingAndSortingRepository<TimeEntry, Long> {
    @Override
    List<TimeEntry> findAll();

    void deleteById(Integer id);

    Page<TimeEntry> findAllByOrderByStartedDesc(Pageable pageable);
    TimeEntry findById(int id);
}
