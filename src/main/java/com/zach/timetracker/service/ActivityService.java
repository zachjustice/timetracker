package com.zach.timetracker.service;

import com.zach.timetracker.domain.Activity;
import javassist.tools.web.BadHttpRequest;

import java.util.List;

public interface ActivityService {
    Activity saveActivity(Activity activity) throws BadHttpRequest;
    List<Activity> findAll();
}
