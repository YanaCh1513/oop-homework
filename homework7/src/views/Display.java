package views;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import models.*;

import java.util.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

// Все методы для работы с консолью.
public class Display implements IDisplay {
    public Display(InputStream in, PrintStream out) {
        this.scanner = new Scanner(System.in);
        this.out = out;
    }

    private Scanner scanner;
    private PrintStream out;

    // просто добавляю в конец слово выход, чтобы было понятно, что программа
    // отработала
    @Override
    public void displayExitMessage() {
        out.println();
        out.println();
        out.println("Выход");
    }

    @Override
    public Boolean getConfirmationFromDisplay() {
        // подтверждение добавить еще один фильтр
        out.println();
        out.println("Ваше действие? y(да)/n(нет) ?");
        // scanner.nextLine();
        var confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y");
    }

    @Override
    public void displayFilteredNotebook(INotebook notebook, Filter filter) {
        out.println();
        switch (filter.getType()) {
            case FILTER_BY_DAY:
                out.println("Записи блокнота за время " + filter.getValue() + ":");
                displayNotes(notebook.getNotesForDay(filter.getValue()));
                break;
            case FILTER_BY_WEEK:
                out.println("Записи блокнота за неделю начиная с " + filter.getValue() + ":");
                displayNotes(notebook.getNotesForWeek(filter.getValue()));
                break;
        }
    }

    @Override
    public void displayNotebook(INotebook notebook) {
        // очистить экран
        clearScreen();

        // вывод записей
        out.println("Все доступные записи блокнота:");
        displayNotes(notebook.getNotes());

        out.println();
    }

    private void displayNotes(List<Note> notes) {
        var i = 1;

        out.println("------------------------------");

        out.printf("%-3s %-5s %-5s \n",
                "№", "DATE", "DESCRIPTION");

        out.println("------------------------------");

        if (notes.size() == 0) {
            out.println("<пусто>");
            return;
        }

        for (var note : notes) {
            // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
            out.printf(
                    // "%d. RAM:%-5s HDD:%-5s OS:%-8s COLOR:%s \n",
                    "%d.  %-5s %-5s \n",
                    i,
                    note.getDateTimeAsString(),
                    note.getDescription());
            i++;
        }
    }

    @Override
    public void displayFilterTypes() {
        var i = 1;
        for (ActionType filterType : ActionType.values()) {
            out.println(i + " - " + ActionType.getDescription(filterType));
            i++;
        }
    }

    @Override
    public LocalDateTime getDateTimeFromDisplay() {
        var str = getStringDataFromDisplay();
        return (new Note(str, "")).getDateTime();
    }

    @Override
    public String getStringDataFromDisplay() {
        out.println("Введите дату в фотмате YY-MM-DD HH:mm");
        return scanner.nextLine();
    }

    @Override
    public Note getNewNoteFromDisplay() {
        out.println();

        out.println("Добавление новой записи");
        out.println("------------------------------");

        var date = getStringDataFromDisplay();

        out.println("Введите событие");
        var disctiption = scanner.nextLine();

        // scanner.nextLine(); // очистить буфер
        out.println();

        return new Note(date, disctiption);
    }

    @Override
    public void displayLoadSuccessfully() {
        out.println("Загружено...");
        try {
            Thread.sleep(1000);
            // TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void displaySavedSuccessfully() {
        // Thread.sleep(1000);
        out.println("Сохранено...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ActionType getActionFromDisplay() {
        out.println();
        out.println("Работа с блокнотом");
        out.println("------------------");
        out.println("Введите цифру, соответствующего действия:");
        out.println();

        displayFilterTypes();

        ActionType criteriaType = ActionType.parce(scanner.nextInt());
        // out.println();

        scanner.nextLine(); // очистили буффер

        return criteriaType;
    }

    @Override
    public void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }
}
