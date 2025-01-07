import java.util.ArrayList;

import models.*;
import views.*;
import services.*;

public class App {
    public static void main(String[] args) throws Exception {

        var display = new Display(System.in, System.out);
        var repository = new NotebookRepository("notebook.dat");
        // var filters = new ArrayList<Filter>();
        Filter filter = null;

        var notebook = repository.load();

        // notebook.add(new Note("2024-12-11 13:34", "Турнир по НТ"));
        // notebook.add(new Note("2024-12-12 12:34", "Кормление пингвина"));
        // repository.save(notebook);

        // filling filters
        var continueFiltering = true;
        while (continueFiltering) {

            display.displayNotebook(notebook);

            if (filter != null)
                display.displayFilteredNotebook(notebook, filter);
            // continueFiltering = display.getConfirmationFromDisplay();
            // if (continueFiltering) {
            var actionType = display.getActionFromDisplay();
            switch (actionType) {
                case ADD_NEW:
                    var note = display.getNewNoteFromDisplay();
                    notebook.add(note);
                    break;
                case FILTER_BY_DAY:
                    var filterDayTime = display.getDateTimeFromDisplay();
                    filter = new Filter(FilterType.FILTER_BY_DAY, filterDayTime);
                    break;
                case FILTER_BY_WEEK:
                    var filterWeekTime = display.getDateTimeFromDisplay();
                    filter = new Filter(FilterType.FILTER_BY_WEEK, filterWeekTime);
                    break;
                case SAVE:
                    display.displaySavedSuccessfully();
                    repository.save(notebook);
                    break;
                case LOAD:
                    display.displayLoadSuccessfully();
                    notebook = repository.load();
                    filter = null;
                    break;
            }
            // }
        }

        // display.displayNotes(notebook.getNotes(), filters);
        // display.displayFilteredLaptops(notebook.getNotes());

        display.displayExitMessage();
    }
}
