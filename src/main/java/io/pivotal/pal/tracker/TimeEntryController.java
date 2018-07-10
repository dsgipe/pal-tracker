package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create( @RequestBody TimeEntry timeEntryToCreate) {

        timeEntryRepository.create(timeEntryToCreate);

        return new ResponseEntity<TimeEntry>(timeEntryToCreate, HttpStatus.CREATED);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        TimeEntry returnTimeEntry =timeEntryRepository.update(id,expected);
        if (returnTimeEntry != null){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<TimeEntry>(returnTimeEntry, httpStatus);

    }

    @DeleteMapping ("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {


        timeEntryRepository.delete(id);

        return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {


        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        TimeEntry returnTimeEntry =timeEntryRepository.find(id);
        if (returnTimeEntry != null){
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<TimeEntry>(returnTimeEntry, httpStatus);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);

    }
}
