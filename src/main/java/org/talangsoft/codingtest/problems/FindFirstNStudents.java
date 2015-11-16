package org.talangsoft.codingtest.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by admin on 21/04/15.
 */
public class FindFirstNStudents {

    public static void main(String... arguments){
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("a",4.0d));
        allStudents.add(new Student("b",3.0d));
        allStudents.add(new Student("c",3.1d));
        allStudents.add(new Student("d",1.0d));
        allStudents.add(new Student("e",0.0d));

        int numberN = 5;
        List<Student> firstNStudent = new FindFirstNStudents().findFirstNStudents(allStudents,numberN);
        System.out.println(String.format("Find the best '%s' students:",numberN));

        for(Student s : firstNStudent){
            System.out.println(s);
        }
    }

    public List<Student> findFirstNStudents(List<Student> allStudents,int n){
        allStudents.sort(studentScoreComparator);
        return allStudents.subList(0,n);
    }

    Comparator<Student> studentScoreComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getScore()>=s2.getScore()? -1:1;
        }
    };

    public static class Student{
        private String name;
        private double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public double getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
