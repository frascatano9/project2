package com.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class Main
{
    public static void main(String[] args){


        List<Student> studentList = new ArrayList<Student>();


            Student st = new Student(1, "Andrea", 2.5);
        Student st1 = new Student(2, "Andrea2", 2.5);
        Student st2 = new Student(3, "Andrea3", 6);
        Student st3 = new Student(3, "Andrea", 10);
            studentList.add(st1);
        studentList.add(st2);
        studentList.add(st);
        studentList.add(st3);

//test aaaa ghghhgg ggggttg
        Map<String,Double> sumAndreaCgpa = studentList.stream()
                .filter(x -> x.getFname().equals("Andrea"))
                .collect(Collectors.groupingBy(Student::getFname,Collectors.summingDouble(Student::getCgpa)))
                ;
        System.out.println("Andreas cgpa "+sumAndreaCgpa);

        Map<String,Long> andreas = studentList.stream().collect(Collectors.groupingBy(Student::getFname,Collectors.counting()));
        System.out.println("Andreas "+andreas);

        Object key = Collections.max(andreas.entrySet(), Map.Entry.comparingByValue()).getValue();
        System.out.println("key "+key);


  studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getCgpa)
                        .reversed())
                .filter( x -> x.getFname().equals("Andrea"))
                .limit(1)
          .forEach(m ->
                System.out.println("AndreaMax " + m.getCgpa()));


        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getCgpa)
                        .reversed()
                        .thenComparing(Comparator.comparing(Student::getFname))
                        .thenComparing(Comparator.comparingInt(Student::getId)))
                 //.map(Student::getFname)
                 .forEach(m ->
                         System.out.println("list sort " + m.getFname()));
 // filter
        studentList.stream()
                .filter( x -> x.getCgpa() < 6)
                .sorted(Comparator.comparingDouble(Student::getCgpa)
                        .reversed()
                        .thenComparing(Comparator.comparing(Student::getFname))
                        .thenComparing(Comparator.comparingInt(Student::getId)))
                //.map(Student::getFname)
                .forEach(m ->
                        System.out.println("Filter sort " + m.getFname()));



    }
}




