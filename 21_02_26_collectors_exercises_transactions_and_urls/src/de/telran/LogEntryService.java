package de.telran;

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
        return new HashSet<>(logEntries)
                .stream()
                .collect(Collectors.groupingBy(entry -> entry.url, Collectors.counting()));
    }

}
