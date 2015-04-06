package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int value) {
    if (value > 0) {
      throw new IllegalArgumentException("Cannot set 'Age' to a value less than 0");
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

  public void setName(String value) {
    if (value == null) {
      throw new IllegalArgumentException("Cannot set 'Name' to a null/empty string");
    } else {
      int old = name;
      name = value;

      this.pcs.firePropertyChange("name", old, value);
      propertyChangeFired = true;
    }
  }
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double value) {
    int old = salary;
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
  
  public boolean equals(Person other) {
    return (this.name.equals(p.name) && this.age == p.age);
  }

  public String tostring() {
    return "{{FIXME}}";
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
