package lang.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 比较List和Set的区别
 */
public class SetTest {
    public static void main(String[] args) {
        Person p1 = new Person("lxp", 10);
        Person p2 = new Person("lxp", 10);
        Person p3 = new Person("lxp", 20);

        // list可重复无序
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(p1);
        System.out.println("---------");
        list.add(p2);
        System.out.println("---------");
        list.add(p3);
        System.out.println("List size=" + list.size());// size=3

        System.out.println("----分割线-----");

        // Set不可重复有序
        Set<Person> set = new HashSet<Person>();
        set.add(p1);
        System.out.println("---------");
        set.add(p2);
        System.out.println("---------");
        set.add(p3);
        System.out.println("Set size=" + set.size());// size=2
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("Call equals();name=" + name);
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;
            return name.equals(person.name);

        }

        @Override
        public int hashCode() {
            System.out.println("Call hashCode(),age=" + age);
            return age;
        }
    }
}