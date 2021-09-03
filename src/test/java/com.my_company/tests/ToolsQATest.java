package com.my_company.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQATest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Tom";
        String lastName = "Cruise";
        String email = "tom_cruise@gmail.com";
        String sexMale = "Male";
        String userNumber = "77777777777";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-1]").click();
        $(".custom-control-input").selectRadio(sexMale);
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").setValue("03 Jul 1962");
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\OTretyakova\\Pictures\\test_pic.jpg"));

    }

}
