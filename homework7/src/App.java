import java.util.ArrayList;

import models.*;
import views.*;
import services.*;

public class App {
    public static void main(String[] args) throws Exception {

        var display = new Display(System.in, System.out);
        var repository = new NotebookRepository("notebook.dat");
        var filters = new ArrayList<Filter>();

        var notebook = repository.load();

        // notebook.add(new Note("2024-12-11 13:34", "Турнир по НТ"));
        // notebook.add(new Note("2024-12-12 12:34", "Кормление пингвина"));
        // repository.save(notebook);

        // filling filters
        var continueFiltering = true;
        while (continueFiltering) {
            display.displayLaptopsAndFilters(notebook.getNotes(), filters);

            // continueFiltering = display.getConfirmationFromDisplay();
            // if (continueFiltering) {
            var actionType = display.getActionFromDisplay();
            switch (actionType) {
                case ADD_NEW:
                    break;
                case FILTER_BY_DAY:
                    break;
                case FILTER_BY_WEEK:
                    break;
                case SAVE:
                    break;
                case LOAD:
                    break;

            }
            // }
        }

        display.displayLaptopsAndFilters(notebook.getNotes(), filters);
        display.displayFilteredLaptops(notebook.getNotes());

        display.displayExitMessage();
    }
}
