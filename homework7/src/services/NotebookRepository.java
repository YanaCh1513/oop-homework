package services;

import java.io.*;
import java.time.LocalDateTime;
//import java.util.*;
import models.*;

public class NotebookRepository implements INotebookRepository {
    public NotebookRepository(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    // @Override
    // public void save(Notebook notebook) throws IOException {
    // try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
    // for (Note note : notebook.getNotes()) {
    // writer.write(note.toString());
    // writer.newLine();
    // }
    // }
    // }

    // @Override
    // public Notebook load() throws IOException {
    // var notebook = new Notebook();
    // try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    // String line;
    // while ((line = reader.readLine()) != null) {
    // String[] parts = line.split(": ", 2);
    // LocalDateTime dateTime = LocalDateTime.parse(parts[0]);
    // String description = parts[1];
    // notebook.add(new Note(dateTime, description));
    // }
    // }
    // return notebook;
    // }

    @Override
    public void save(Notebook familyTree)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public Notebook load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName))) {
            return (Notebook) ois.readObject();
        }
    }
}
