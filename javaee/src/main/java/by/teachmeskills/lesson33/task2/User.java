package by.teachmeskills.lesson33.task2;

import by.teachmeskills.lesson33.task1.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User implements Cloneable {

    private Person person;

    private String login;

    private String password;

    @Override
    public User clone() throws CloneNotSupportedException {
        User copy = (User) super.clone();
        copy.person = person.clone();
        return copy;
    }
}
