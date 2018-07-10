package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public  interface TimeEntryRepository {


    public TimeEntry create(TimeEntry timeEntry) ;
    public TimeEntry find(long id);

    public List<TimeEntry> list();

    public TimeEntry update(long id, TimeEntry timeEntry);

    public void delete(long id);
}
/*    @Override
    public ResponseEntity create(TimeEntry any) {
        return  null;
    }

    @Override
    public void find(long l) {

    }

    @Override
    public ResponseEntity update(long eq, TimeEntry any) {
        return null;
    }

    @Override
    public ResponseEntity<TimeEntry> delete(long l) {
        return null;
    }

    @Override
    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }
    */