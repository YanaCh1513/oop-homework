import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

}