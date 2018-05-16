package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    Map<Long, TimeEntry> map = new HashMap<>();

    @Override
    public TimeEntry find(long id) {
        return map.get(id);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(map.size()+1);
        map.put(Long.valueOf( map.size()+1), timeEntry);
        return map.get(Long.valueOf( map.size()));
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList(map.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry te) {
        TimeEntry timeEntry = map.get(id);
        timeEntry.setProjectId(te.getProjectId());
        timeEntry.setUserId(te.getUserId());
        timeEntry.setDate(te.getDate());
        timeEntry.setHours(te.getHours());
        map.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public void delete(long id) {
        map.remove(id);
    }
}
