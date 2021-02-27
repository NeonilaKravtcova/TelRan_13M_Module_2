package de.telran;

public class LogEntry {

    String login;
    String url;

    public LogEntry(String login, String url) {
        this.login = login;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry)) return false;

        LogEntry logEntry = (LogEntry) o;

        if (!login.equals(logEntry.login)) return false;
        return url.equals(logEntry.url);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "login " + login + ", url = " + url + "\n";
    }
}
