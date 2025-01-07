package views;

import java.time.LocalDateTime;

import models.INotebook;
import models.Note;

public interface IDisplay {

    // просто добавляю в конец слово выход, чтобы было понятно, что программа
    // отработала
    void displayExitMessage();

    Boolean getConfirmationFromDisplay();

    void displayFilteredNotebook(INotebook notebook, Filter filter);

    void displayNotebook(INotebook notebook);

    void displayFilterTypes();

    LocalDateTime getDateTimeFromDisplay();

    String getStringDataFromDisplay();

    Note getNewNoteFromDisplay();

    void displayLoadSuccessfully();

    void displaySavedSuccessfully();

    ActionType getActionFromDisplay();

    void clearScreen();

}