package com.my_company.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ToolsQATest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
    }

    @Test
    void fillFormTest() {
        String firstName = "Tom";
        String lastName = "Cruise";
        String email = "tom_cruise@gmail.com";
        String sex = "Male";
        String userNumber = "77777777777";
        String address = "USA";
        String state = "NCR";
        String city = "Noida";
        String subject = "Math";
        String day = "03";
        String month = "July";
        String year = "1962";
        String hobby = "Sports";
        String fileName = "photo.jpg";
        open("https://demoqa.com/automation-practice-form");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(sex)).click();
        $("#userNumber").setValue(userNumber);
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(byText(day)).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);

        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();
        $("#submit").click();

    }

}
