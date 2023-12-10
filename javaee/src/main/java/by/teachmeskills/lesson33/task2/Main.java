package by.teachmeskills.lesson33.task2;

import by.teachmeskills.lesson33.task1.Person;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User(new Person("", "", ""), "l", "");
        User copy = user.clone();
        System.out.println(user.getPerson() == copy.getPerson()); // false
    }
}
