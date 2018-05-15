package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface TimeEntryRepository {

    TimeEntry find(long id);
    TimeEntry create(TimeEntry timeEntry);
    List<TimeEntry> list();
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
}
