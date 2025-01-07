package services;

import java.io.*;

public class FileRepository<T> implements IRepository<T> {
    public FileRepository(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    @Override
    public void save(T familyTree)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public T load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName))) {
            return (T) ois.readObject();
        }
    }
}
