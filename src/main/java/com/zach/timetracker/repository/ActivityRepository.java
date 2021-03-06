package com.zach.timetracker.repository;

import com.zach.timetracker.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Override
    List<Activity> findAll();
    Activity findByLabel(String label);
}
