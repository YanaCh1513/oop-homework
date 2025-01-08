import views.*;
import services.*;
import models.*;
import presenters.IPresenter;
import presenters.Presenter;

public class Main {
    public static void main(String[] args) throws Exception {

        IDisplay notebookView = new Display(System.in, System.out);
        IRepository<INotebook> repository = new FileRepository<INotebook>("notebook.dat");
        IPresenter presenter = new Presenter(notebookView, repository);

        while (true) {

            presenter.display();

            var action = presenter.getAction();
            switch (action) {
                case ADD_NEW:
                    presenter.addNote();
                    break;
                case FILTER_BY_DAY:
                    presenter.filteredByDay();
                    break;
                case FILTER_BY_WEEK:
                    presenter.filteredByWeek();
                    break;
                case SAVE:
                    presenter.save();
                    break;
                case LOAD:
                    presenter.load();
                    break;
            }
        }
    }
}
