package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    Map<Long, TimeEntry> timeEntrys;

    public InMemoryTimeEntryRepository() {
        timeEntrys = new HashMap<Long,TimeEntry>();
    }

    public TimeEntry create(TimeEntry timeEntry) {

        if(find(timeEntry.getId()) != null) {
            timeEntry.setId(timeEntry.getId()+1);
            timeEntrys.put(timeEntry.getId(), timeEntry);
        }else{
            timeEntrys.put(timeEntry.getId(), timeEntry);
        }

        return timeEntry;
    }

    public TimeEntry find(long id){

        return timeEntrys.get(id);
    }

    public List<TimeEntry> list() {
        return  new ArrayList<TimeEntry>(timeEntrys.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntrys.put(timeEntry.getId(), timeEntry);

        return find(id);
    }

    public void delete(long id) {
        timeEntrys.remove(id);
    }
}
