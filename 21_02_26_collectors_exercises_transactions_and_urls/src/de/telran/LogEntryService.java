package de.telran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogEntryService {

    public Map<String, Long> clickCounter(List<LogEntry> logEntries){
        return logEntries
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.url, Collectors.counting()));
    }

    public Map<String, Long> getUniqueEntriesByUrl(List<LogEntry> logEntries){

/*        return logEntries
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(HashSet::new), ArrayList::new))
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.url, Collectors.counting()));*/


        List<LogEntry> uniqueLogEntries =  logEntries
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(HashSet::new), ArrayList::new));

        return clickCounter(uniqueLogEntries);
    }


}
