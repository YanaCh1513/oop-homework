import models.*;
import services.*;

import java.util.List;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        var kate = new Person("Kate", 2011);
        var john = new Person("John", 2014);
        var susan = new Person("Susan", 1990);

        var familyTree = new FamilyTree<Person>();
        // Добавляем людей в древо
        familyTree.addPerson(john);
        familyTree.addPerson(kate);
        familyTree.addPerson(susan);

        john.addChild(kate);
        john.addChild(susan);

        familyTree.sortByName();

        // Пример получения всех детей Джона
        List<Person> johnsChildren = john.getChildren(); // familyTree.getChildren(john);
        for (Person child : johnsChildren) {
            System.out.println("John's child: " + child.getName());
        }

        IFamilyTreeRepository repository = new FamilyTreeRepository("FamilyTree.dat");
        try {
            repository.save(familyTree);
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Загружаем генеалогическое древо из файла
        FamilyTree<Person> loadedFamilyTree = null;
        try {
            loadedFamilyTree = repository.load();
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person: " +
                        person.getName() + ", born in " + person.getBirthYear());
            }
        }

    }

}
