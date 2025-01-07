package services;

import java.io.IOException;

import models.Notebook;

public interface INotebookRepository {
    void save(Notebook familyTree) throws IOException;

    Notebook load() throws IOException,
            ClassNotFoundException;
}