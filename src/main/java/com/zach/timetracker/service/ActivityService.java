package com.zach.timetracker.service;

import com.zach.timetracker.domain.Activity;

import java.util.List;

public interface ActivityService {
    Activity saveActivity(Activity activity);
    List<Activity> findAll();
}
