package com.zach.timetracker.service;

import com.zach.timetracker.domain.Activity;
import com.zach.timetracker.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }
}
