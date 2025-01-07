package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.*;

public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime dateTime;
    private String description;

    String str = "1986-04-08 12:30";

    private LocalDateTime parce(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    private String format(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        String formattedDateTime = date.format(formatter); // "1986-04-08 12:30"
        return formattedDateTime;
    }

    public Note(String dateTime, String description) {
        this.dateTime = parce(dateTime);
        this.description = description;
    }

    public Note(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getDateTimeAsString() {
        return format(dateTime);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

}
