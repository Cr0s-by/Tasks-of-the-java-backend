package ru.evolenta.dto;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String surname;
    private String lastname;
    private LocalDate birthday;

    public Person() {
    }

    public Person(int id, String firstname, String surname, String lastname, LocalDate birthday, List<Message> messages) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.messages = messages;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Message> getMessages() {  // Правильный геттер
        return messages;
    }

    public void setMessage(Message message) {
        this.messages = messages;
    }
}