import java.io.*;

// Реализация интерфейса для операций с файлами
public class FamilyTreeRepository implements IFamilyTreeRepository {

    public FamilyTreeRepository(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    @Override
    public void save(FamilyTree familyTree)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileName))) {
            return (FamilyTree) ois.readObject();
        }
    }
}
