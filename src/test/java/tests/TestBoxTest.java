package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.commands.UploadFile;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTest {
    @Test
    void studentRegistrationForm() {
        String firstName = "Bill";
        String lastName = "Funny";
        String userEmail = "horse@yahoo.com";
        String userNumber = "1253643652";
        String subject = "Biology";
        String currentAddress = "Lenina street house";
        String state = "NCR";
        String city = "Delhi";


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Sports")).scrollTo().click(); //doesn't click element without scroll
        $("#uploadPicture").uploadFile(new File("src/test/resources/radio.jpeg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Student Name"), text(firstName + " " + lastName),
                text("Student Email"), text(userEmail),
                text("Gender"), text("Male"),
                text("Mobile"), text(userNumber),
                text("Date of Birth"), text("13 March,1990"),
                text("Subjects"), text(subject),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("radio.jpeg"),
                text("Address"), text(currentAddress),
                text("State and City"), text(state + " " + city)
        );
        //sleep(3000);


    }
}
