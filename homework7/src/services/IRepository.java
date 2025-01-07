package services;

import java.io.IOException;

//import models.Notebook;

public interface IRepository<T> {
    void save(T familyTree) throws IOException;

    T load() throws IOException,
            ClassNotFoundException;
}