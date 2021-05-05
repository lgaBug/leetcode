package com.lga.source.analyze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FunctionTestMain {

    public static void main(String[] args) {

//        testDeepOrSimpleCopy();

        testIteraotor();

    }

    public static void testArrayCopy() {

        int[] arrays = new int[]{1, 2, 3, 4, 5};
        int[] newArrays = new int[5];

        System.arraycopy(arrays, 1, newArrays, 3, 2);

        System.out.println(Arrays.toString(arrays));
        System.out.println(Arrays.toString(newArrays));

        newArrays[4] = 9;

        System.out.println(Arrays.toString(arrays));
        System.out.println(Arrays.toString(newArrays));
    }

    public static void testDeepOrSimpleCopy() {

        Person[] persons = new Person[]{new Person("a"), new Person("b"), new Person("c")};

        Person[] newPersons = new Person[3];

        System.arraycopy(persons, 0, newPersons, 0, 3);

        System.out.println(Arrays.toString(persons));
        System.out.println(Arrays.toString(newPersons));

        System.out.println("----------------");

        persons[2].setName("cccccc");

        System.out.println(persons == newPersons);
        System.out.println(Arrays.toString(persons));
        System.out.println(Arrays.toString(newPersons));
    }

    public static void testIteraotor() {

        ArrayList<String> strs = new ArrayList(){
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");

            }
        };

        Iterator<String> iterator = strs.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("c".equals(next)) {
                iterator.remove();
            }
            System.out.println("next = " + next);
        }

        System.out.println("strs = " + strs);



    }


    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
