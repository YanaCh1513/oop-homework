package presenters;

import java.io.IOException;

import models.INotebook;
import services.IRepository;
import views.*;

public class Presenter implements IPresenter {
    public Presenter(
            IDisplay display,
            IRepository<INotebook> repository) throws ClassNotFoundException, IOException {
        this.display = display;
        this.repository = repository;
        this.notebook = repository.load();
    }

    private Filter filter = null;
    private IDisplay display = null;
    private INotebook notebook = null;
    private IRepository<INotebook> repository = null;

    @Override
    public void display() {
        display.displayNotebook(notebook);
        if (filter != null) {
            display.displayFilteredNotebook(notebook, filter);

        }
    }

    @Override
    public ActionType getAction() {
        return display.getActionFromDisplay();
    }

    @Override
    public void addNote() {
        var note = display.getNewNoteFromDisplay();
        notebook.add(note);
    }

    @Override
    public void filteredByDay() {
        var filterDayTime = display.getDateTimeFromDisplay();
        filter = new Filter(FilterType.FILTER_BY_DAY, filterDayTime);
    }

    @Override
    public void filteredByWeek() {
        var filterWeekTime = display.getDateTimeFromDisplay();
        filter = new Filter(FilterType.FILTER_BY_WEEK, filterWeekTime);
    }

    @Override
    public void save() throws IOException {
        display.displaySavedSuccessfully();
        repository.save(notebook);
    }

    @Override
    public void load() throws ClassNotFoundException, IOException {
        display.displayLoadSuccessfully();
        notebook = repository.load();
        filter = null;
    }
}
