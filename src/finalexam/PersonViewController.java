/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class PersonViewController implements Initializable {
    
    @FXML private TextField firstNameField;

    @FXML private TextField lastNameField;

    @FXML private DatePicker birthdayPicker;

    @FXML private RadioButton genderMale;

    @FXML private RadioButton genderFemale;
          private ToggleGroup genderToggleGroup;

    @FXML private Label personLabel;

    @FXML private Button createPersonButton;
    
    String gender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personLabel.setText("");
        
        //configure the radio buttons and toggle group
        genderToggleGroup = new ToggleGroup();
        genderMale.setToggleGroup(genderToggleGroup);
        genderFemale.setToggleGroup(genderToggleGroup);
    } 
    
    /**
     * This will update the gender every time a radio button is pressed
     */
    public void radioButtonChanged()
    {
        if (genderToggleGroup.getSelectedToggle().equals(this.genderMale))
            gender = "Male";
        if (genderToggleGroup.getSelectedToggle().equals(this.genderFemale))
            gender = "Female";
    }
    
    /**
     * This will create a person object with the information from the view
     */
    public void createPersonButtonPushed(){
        try{
            //save object into variables
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            LocalDate birthday = birthdayPicker.getValue();

            //create person object
            Person person = new Person(firstName, lastName, gender, birthday);

            //display created person using toSting()
            personLabel.setText(person.toString()+" was created");
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }
    
}
