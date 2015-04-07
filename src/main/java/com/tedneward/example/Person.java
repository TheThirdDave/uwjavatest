package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private final static int population = 0;

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
      int old = age;
      age = value;

      this.pcs.firePropertyChange("age", old, value);
      propertyChangeFired = true;
    }
  }
  
  public String getName() {
    return name;
  }

  public void setname(String value) {
    if (value == null) {
      throw new IllegalArgumentException("The name of a person needs to not be a null string, must cotain characters.");
    } else {
      String old = name;
      name = value;

      this.pcs.firePropertyChange("name", old, value);
      propertyChangeFired = true;
    }
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double value) {
    double old = salary;
    salary = value;

    this.pcs.firePropertyChange("salary", old, value);
    propertyChangeFired = true;
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
  
  public boolean equals(Person p) {
    return (this.name.equals(p.name) && this.age == p.age);
  }

  public String tostring() {
    return "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
  }

  //@Override
  public int compareTo(Person otherPerson) {
    if (this.salary == otherPerson.salary) {
      return 0;
    } else if (this.salary > otherPerson.salary) {
      return -1;
    } else {
      return 1;
    }
  }

  public class AgeComparator implements Comparator<Person> {
    public int compare(Person one, Person two) {
      return one.age.compareTo(two.age);
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
