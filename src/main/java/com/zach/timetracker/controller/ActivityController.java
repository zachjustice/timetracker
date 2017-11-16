package com.zach.timetracker.controller;

import com.zach.timetracker.domain.Activity;
import com.zach.timetracker.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ActivityController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping(value = "/api/activity", method = RequestMethod.POST)
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        activityService.saveActivity(activity);
        logger.info("Saved Activity: " + activity.toString());

        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/activities", method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> findAllActivities() {
        List<Activity> activities = activityService.findAll();

        return new ResponseEntity<>(activities, HttpStatus.OK);
    }
}
