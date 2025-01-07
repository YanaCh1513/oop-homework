package models;

import java.time.LocalDateTime;
import java.util.List;

public interface INotebook {
    void add(Note note);

    List<Note> getNotes();

    List<Note> getNotesForDay(LocalDateTime dateTime);

    List<Note> getNotesForWeek(LocalDateTime startOfWeek);
}
