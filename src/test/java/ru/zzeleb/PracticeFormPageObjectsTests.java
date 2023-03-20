package ru.zzeleb;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String name = "Artem";
        String surname = "Zeleb";
        String email = "zeleb@inbox.ru";
        String gender = "Male";
        String number = "9042545658";
        String day = "16";
        String month = "October";
        String year = "1985";
        String picture = "123.jpg";
        String subject = "Maths";
        String hobby = "Reading";
        String address = "Nevskiy 5, 15";
        String state = "Haryana";
        String city = "Karnal";

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(number)
                .setBirthDate(day,month,year)
                .setSubject(subject)
                .setHobby(hobby)
                .setUserPicture(picture)
                .setUserAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", name +" " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }


}
