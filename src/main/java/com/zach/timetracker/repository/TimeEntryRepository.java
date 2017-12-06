package com.zach.timetracker.repository;

import com.zach.timetracker.domain.TimeEntry;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository  extends JpaRepository<TimeEntry, Long> {
    @Override
    List<TimeEntry> findAll();

    void deleteById(Integer id);

    @Query(
            value = "select * from time_entries ORDER BY  started DESC LIMIT :limit OFFSET :offset",
            nativeQuery = true
    )
    List<TimeEntry> findAllByOrderByStartedDesc(@Param("limit") int limit, @Param("offset") int offset);
    TimeEntry findById(int id);
}
