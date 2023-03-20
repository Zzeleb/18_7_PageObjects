package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement subjectInput = $("#subjectsInput");
    private SelenideElement hobbyInput = $("#hobbiesWrapper");
    private SelenideElement userPictureUpload = $("#uploadPicture");
    private SelenideElement userAddressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement setUserState = $("#stateCity-wrapper");
    private SelenideElement setUserCity = $("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText("Male")).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

        public RegistrationPage setUserPicture(String value) {
        userPictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserStateCity(String state, String city) {
        stateSelect.click();
        setUserState.$(byText(state)).click();
        citySelect.click();
        setUserCity.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submitForm () {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
       registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
