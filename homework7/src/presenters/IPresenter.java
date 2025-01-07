package presenters;

import java.io.IOException;

import views.ActionType;

public interface IPresenter {

    void display();

    ActionType getAction();

    void addNote();

    void filteredByDay();

    void filteredByWeek();

    void save() throws IOException;

    void load() throws ClassNotFoundException, IOException;

}