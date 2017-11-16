package com.zach.timetracker.controller;

import com.zach.timetracker.domain.TimeEntry;
import com.zach.timetracker.service.TimeEntryService;
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
public class TimeEntryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @RequestMapping(value = "/api/time", method = RequestMethod.POST)
    public ResponseEntity<TimeEntry> createTimeEntry(@RequestBody TimeEntry timeEntry) {
        timeEntryService.saveTimeEntry(timeEntry);
        logger.info("Saved TimeEntry: " + timeEntry.toString());

        return new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/time", method = RequestMethod.GET)
    public ResponseEntity<List<TimeEntry>> findAllTimeEntries() {
        List<TimeEntry> timeEntries = timeEntryService.findAll();
        return new ResponseEntity<>(timeEntries, HttpStatus.OK);
    }
}
