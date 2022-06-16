package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.RegisterPO;
import utilities.ThreadManager;

public class RegisterSteps {
    private AppiumDriver<WebElement> driver = ThreadManager.getDriver();
    private RegisterPO register = new RegisterPO(driver);

    @Given("user click on hyperlink register")
    public void user_click_on_hyperlink_register() {
        register.clickOnHyperlinkRegister();
    }

    @When("user input complete name {string} to field fullname")
    public void user_input_complete_name_to_field_fullname(String fullname) {
        register.enterFullname(fullname);
    }

    @When("user input phone number {string} to field phone number")
    public void user_input_phone_number_to_field_phone_number(String phoneNumber) {
        register.enterPhoneNumber(phoneNumber);
    }

    @When("user input email valid {string} to field email")
    public void user_input_email_valid_to_field_email(String email) {
        register.enterEmail(email);
    }

    @When("user input mothers name {string} to field mothers name")
    public void user_input_mothers_name_to_field_mothers_name(String mothersName) {
        register.enterMothersName(mothersName);
    }

    @When("user choose selected nationality WNI to field select nationality")
    public void user_choose_selected_nationality_wni_to_field_select_nationality() throws InterruptedException {
        register.clickOnNationality();
        register.clickChooseWNI();
    }

    @When("user input location {string}")
    public void user_input_location(String cityName){
        register.enterCityName(cityName);
    }

    @When("user choose location Jakarta Indonesia")
    public void user_choose_location_jakarta_indonesia() throws InterruptedException {
        register.clickOnJakartaIndoneria();
    }

    @When("user input code referral {string}")
    public void user_input_code_referral(String codeReferral){
        register.enterCodeReferral(codeReferral);
    }

    @When("user input password {string} user input password {string}")
    public void user_input_password_user_input_password(String password, String rePassword){
        register.enterPassword(password);
        register.enterRePassword(rePassword);
    }

    @When("user input pin number {string}")
    public void user_input_pin_number(String pinNumber){
        register.enterPinNumber(pinNumber);
    }

    @When("user click upload photo personal and ktp and click choose from gallery")
    public void user_click_upload_photo_personal_and_ktp_and_click_choose_from_gallery() throws InterruptedException{
        register.clickOnUploadPhotoAndKTP();
        register.clickOnChooseFromGallery();
        register.clickOnChoosePhoto();
    }

    @When("user click upload ktp and choose file photo from gallery")
    public void user_click_upload_ktp_and_choose_file_photo_from_gallery() throws InterruptedException{
        register.clickOnUploadKTP();
        register.clickOnChooseFromGallery();
        register.clickOnChoosePhotoKTP();
    }

    @When("user click checklist on term and condition")
    public void user_click_checklist_on_term_and_condition() throws InterruptedException{
        register.clickOnChecklistTnC();
    }

    @When("user click registrasi button")
    public void user_click_registrasi_button() throws InterruptedException{
        register.clickOnRegistrasiButton();
    }

    @When("user click ok on confirm registration")
    public void user_click_ok_on_confirm_registration() throws InterruptedException{
        register.clickOnConfirmButton();
    }

    @Then("system display toast with message {string}")
    public void system_display_toast_with_message(String message) {
        Assert.assertEquals(register.messageToastSuccess(message), message, "Registrasi Berhasil");
    }
}