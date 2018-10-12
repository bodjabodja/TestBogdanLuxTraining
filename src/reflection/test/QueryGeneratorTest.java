package reflection.test;

import org.junit.Test;
import reflection.main.Column;
import reflection.main.ID;
import reflection.main.QueryGenerator;
import reflection.main.Table;

import static org.junit.Assert.*;



public class QueryGeneratorTest {
    @Test
    public void testGetAll() throws Exception {
        QueryGenerator queryGenerator = new QueryGenerator();
        String actual = queryGenerator.getAll(Person.class);
        String expected = "SELECT person_id, person_name, salary FROM Persons;";


        assertEquals(expected, actual);

    }

    @Test
    public void testGetById() throws Exception {
        Person p = new Person();
        p.id=1234;
        QueryGenerator queryGenerator = new QueryGenerator();
        String actual = queryGenerator.getById(Person.class,p.id);
        String expected = "SELECT person_name, salary FROM Persons WHERE person_id = "+p.id+";";


        assertEquals(expected, actual);

    }

    @Test
    public void testInsert() throws Exception {
        Person p = new Person();
        p.id=1234;
        p.name = "uasya";
        p.salary = 14000;
        QueryGenerator queryGenerator = new QueryGenerator();
        String actual = queryGenerator.insert(p);
        String expected = "INSERT INTO Persons (person_id, person_name, salary) VALUES  ("+p.id+", "+p.name+", "+p.salary+");";


        assertEquals(expected, actual);

    }

    @Table(name = "Persons")
    private static class Person {
        @ID
        @Column(name = "person_id")
        int id;
        @Column(name = "person_name")
        String name;
        @Column
        double salary;
    }
}
