package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private static int population = 0;

  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public Person() {
    this("", 0, 0.0d);
    population = population++;
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    population = population++;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("The age of a person needs to be greater than 0.");
    } else {
      age = value;
    }
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    if (value == null) {
      throw new IllegalArgumentException("The name of a person needs to not be a null string, must cotain characters.");
    } else {
      name = value;
    }
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double value) {
    salary = value;
  }
  
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  @Override
  public boolean equals(Object otherPerson) {
    if (otherPerson instanceof Person) {
      Person p = (Person) otherPerson;
      return (this.name.equals(p.name) && this.age == p.age);
    }
    return false;
  }

  public String toString() {
    return "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
  }

  @Override
  public int compareTo(Person otherPerson) {
    if (this.salary == otherPerson.salary) {
      return 0;
    } else if (this.salary > otherPerson.salary) {
      return -1;
    } else {
      return 1;
    }
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person one, Person two) {
      return one.age - two.age;
    }
  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> family = new ArrayList<Person>();
    family.add(new Person("Ted", 41, 250000));
    family.add(new Person("Charlotte", 43, 150000));
    family.add(new Person("Michael", 22, 10000));
    family.add(new Person("Matthew", 15, 0));
    return family;
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
