package com.zach.timetracker.service;

import com.zach.timetracker.domain.Activity;
import com.zach.timetracker.repository.ActivityRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity saveActivity(Activity activity) throws BadHttpRequest {
        Activity existing = activityRepository.findByLabel(activity.getLabel());
        if(existing != null) {
            throw new BadHttpRequest();
        }

        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }
}
