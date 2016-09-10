package tasks.task4.task4_4;

import java.io.Serializable;

/**
 * Created by Egor on 10.09.2016.
 */
public class Actor implements Serializable{

    private String firstName;
    private String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = result * 31 + firstName.hashCode();
        result = result * 31 + lastName.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return firstName.equals(((Actor)obj).getFirstName()) &&
                lastName.equals(((Actor)obj).getLastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
