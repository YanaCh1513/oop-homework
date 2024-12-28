import java.io.BufferedReader;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        var kate = new Person("Kate", 2011);
        var john = new Person("John", 2014);
        var susan = new Person("Susan", 1990);

        var familyTree = new FamilyTree();
        // Добавляем людей в древо
        familyTree.addPerson(john);
        familyTree.addPerson(kate);
        familyTree.addPerson(susan);

        john.addChild(kate);
        john.addChild(susan);

        // Пример получения всех детей Джона
        List<Person> johnsChildren = familyTree.getChildren(john);
        for (Person child : johnsChildren) {
            System.out.println("John's child: " + child.getName());
        }
    }

}
