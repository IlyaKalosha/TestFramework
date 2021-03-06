package model;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String surname;
    private String faberlicMoney;
    public Card card;
    private String email;

    public User(String username, String password, String surname, String faberlicMoney) {
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.faberlicMoney = faberlicMoney;
    }
    public User(String username, String password, String surname, String faberlicMoney, Card card, String email) {
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.faberlicMoney = faberlicMoney;
        this.card = card;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getFaberlicMoney() {
        return faberlicMoney;
    }

    public void setFaberlicMoney(String faberlicMoney) {
        this.faberlicMoney = faberlicMoney;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", faberlicMoney='" + faberlicMoney + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, surname);
    }
}
