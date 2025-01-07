package views;

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

import models.*;

import java.util.*;
import java.io.InputStream;
import java.io.PrintStream;

// Все методы для работы с консолью.
public class Display {
    public Display(InputStream in, PrintStream out) {
        this.scanner = new Scanner(System.in);
        this.out = out;
    }

    private Scanner scanner;
    private PrintStream out;

    // просто добавляю в конец слово выход, чтобы было понятно, что программа
    // отработала
    public void displayExitMessage() {
        out.println();
        out.println();
        out.println("Выход");
    }

    public Boolean getConfirmationFromDisplay() {
        // подтверждение добавить еще один фильтр
        out.println();
        out.println("Ваше действие? y(да)/n(нет) ?");
        // scanner.nextLine();
        var confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y");
    }

    public void displayFilteredLaptops(List<Note> notes) {
        out.println();
        out.println("Записи подходящие под фильтры:");
        displayNotes(notes);
    }

    public void displayLaptopsAndFilters(List<Note> notes, List<Filter> filters) {
        // очистить экран
        clearScreen();
        // вывод ноутбуков
        out.println("Все доступные записи блокнота:");
        displayNotes(notes);
        out.println();
        // вывод фильтров
        // displayFilters(filters);
    }

    // private void displayFilters(ArrayList<Filter> filters) {
    // var i = 1;

    // out.println("Фильтры:");
    // out.println("--------");

    // if (filters == null || filters.size() == 0) {
    // out.println("<пусто>");

    // }

    // for (var filter : filters) {
    // //
    // https://javarush.com/en/groups/posts/en.1412.formatting-number-output-in-java
    // out.printf(
    // "%d. %-5s %-5s \n",
    // i,
    // String.valueOf(filter.getType()),
    // filter.getValue());
    // i++;
    // }
    // }

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

    public void displayFilterTypes() {
        var i = 1;
        for (ActionType filterType : ActionType.values()) {
            out.println(i + " - " + ActionType.getDescription(filterType));
            i++;
        }
    }

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

    public void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }
}
