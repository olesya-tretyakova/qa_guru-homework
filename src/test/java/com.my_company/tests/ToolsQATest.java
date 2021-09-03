package com.my_company.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        String userNumber = "1234512345";
        String address = "USA";
        String state = "NCR";
        String city = "Noida";
        String subject = "Math";
        String day = "3";
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
        $("#dateOfBirthInput").click();
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

        $x("//td[.='Student Name']/following-sibling::td").shouldHave(text(firstName + " " + lastName));
        $x("//td[.='Student Email']/following-sibling::td").shouldHave(text(email));
        $x("//td[.='Gender']/following-sibling::td").shouldHave(text(sex));
        $x("//td[.='Mobile']/following-sibling::td").shouldHave(text(userNumber));
        $x("//td[.='Date of Birth']/following-sibling::td").shouldHave(text(day + " " + month + "," + year));
        $x("//td[.='Subjects']/following-sibling::td").shouldHave(text(subject));
        $x("//td[.='Hobbies']/following-sibling::td").shouldHave(text(hobby));
        $x("//td[.='Picture']/following-sibling::td").shouldHave(text(fileName));
        $x("//td[.='Address']/following-sibling::td").shouldHave(text(address));
        $x("//td[.='State and City']/following-sibling::td").shouldHave(text(state + " " + city));
    }
}
