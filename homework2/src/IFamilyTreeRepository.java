import java.io.*;

public interface IFamilyTreeRepository {

    void save(FamilyTree familyTree) throws IOException;

    FamilyTree load() throws IOException,
            ClassNotFoundException;
}
