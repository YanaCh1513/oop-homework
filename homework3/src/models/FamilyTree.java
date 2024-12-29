package models;

import java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {

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

    @Override
    public Iterator<Person> iterator() {
        return this.people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByBirthYear() {
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getBirthYear(), p2.getBirthYear()));
    }

}