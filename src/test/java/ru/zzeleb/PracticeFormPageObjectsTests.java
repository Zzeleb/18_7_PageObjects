package ru.zzeleb;

import org.junit.jupiter.api.Test;

public class PracticeFormPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {
        String name = "Artem";
        String surname = "Zeleb";
        String email = "zeleb@inbox.ru";
        String gender = "Male";
        String number = "9042545658";
        String picture = "123.jpg";
        String subjects = "Maths";
        String hobby = "Reading";
        String address = "Nevskiy 5, 15";
        String state = "Haryana";
        String city = "Karnal";

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(number)
                .setBirthDate("16", "October", "1985")
                .setSubjects(subjects)
                .setHobby(hobby)
                .setUserPicture(picture)
                .setUserAddress(address)
                .setUserStateCity(state, city)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", name +" " + surname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", "16 October,1985")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }


}
