package de.telran;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogEntryServiceTest {

    LogEntry entry01 = new LogEntry("Vasya", "url_01");
    LogEntry entry02 = new LogEntry("Petya", "url_01");
    LogEntry entry03 = new LogEntry("Pavel", "url_02");
    LogEntry entry04 = new LogEntry("Stepan", "url_01");
    LogEntry entry05 = new LogEntry("Vasya", "url_01");
    LogEntry entry06 = new LogEntry("Vasya", "url_01");
    LogEntry entry07 = new LogEntry("Olga", "url_02");
    LogEntry entry08 = new LogEntry("Ivan", "url_02");
    LogEntry entry09 = new LogEntry("Pavel", "url_02");
    LogEntry entry10 = new LogEntry("Pavel", "url_03");
    LogEntry entry11 = new LogEntry("Vasya", "url_03");
    LogEntry entry12 = new LogEntry("Olga", "url_01");
    LogEntry entry13 = new LogEntry("Olga", "url_02");
    LogEntry entry14 = new LogEntry("Pavel", "url_01");
    LogEntry entry15 = new LogEntry("Vasya", "url_01");
    LogEntry entry16 = new LogEntry("Vasya", "url_04");

    List<LogEntry> logEntries = new ArrayList<>(Arrays.asList(entry01, entry02, entry03, entry04, entry05,
            entry06, entry07, entry08, entry09, entry10,
            entry11, entry12, entry13, entry14, entry15, entry16));

    LogEntryService service = new LogEntryService();

    Map<String, Long> res = new HashMap<>();

    @Test
    public void clickCounterTest(){
        res.put("url_01", 8L);
        res.put("url_02", 5L);
        res.put("url_03", 2L);
        res.put("url_04", 1L);
        assertEquals(res, service.clickCounter(logEntries));
    }

    @Test
    public void getUniqueEntriesByUrlTest(){
        res.put("url_01", 5L);
        res.put("url_02", 3L);
        res.put("url_03", 2L);
        res.put("url_04", 1L);
        assertEquals(res, service.getUniqueEntriesByUrl(logEntries));
    }

}
