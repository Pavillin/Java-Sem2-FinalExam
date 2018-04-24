package FinalExam;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author JWright
 */
public class Person
{
    private String firstName, lastName, gender;
    private LocalDate birthday;

    public Person(String firstName, String lastName, String gender, LocalDate birthday)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setBirthday(birthday);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        if (firstName.length()>2 && firstName.length()<15){
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            this.firstName = firstName;
        }
        else
            throw new IllegalArgumentException("First names must be 2-15 characters long");
    }

    
    public int getAge()
    {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        if (!lastName.isEmpty()){
            lastName = lastName.substring(0, 1).toUpperCase()+lastName.substring(1);
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException("Last name cannot be empty");
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
            this.gender = gender.toLowerCase();
        else
            throw new IllegalArgumentException("gender must be male or female");
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        if (!birthday.isAfter(LocalDate.now()))
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Birthday's cannot be in the future");
    }
    
    public String toString()
    {
        return String.format("%s %s", firstName, lastName);
    }
}
