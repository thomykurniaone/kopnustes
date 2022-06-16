package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.AppiumHelpers;

import java.io.File;

public class RegisterPO {
    AppiumHelpers appium;
    AppiumDriver<WebElement> driver;

    public RegisterPO(AppiumDriver<WebElement> driver){
        this.driver = driver;
        appium = new AppiumHelpers(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="registrasi")
    private WebElement registrasiHyperLink;

    @AndroidFindBy(id="fullname")
    private WebElement fullnameEditText;

    @AndroidFindBy(id="phoneNumber")
    private WebElement phoneNumberEditText;

    @AndroidFindBy(id="email")
    private WebElement emailEditText;

    @AndroidFindBy(id="mothersName")
    private WebElement mothersNameEditText;

    @AndroidFindBy(id="selectNationality")
    private WebElement nationalitySelect;

    @AndroidFindBy(id="wni")
    private WebElement wniSelected;

    @AndroidFindBy(id="selectLocation")
    private WebElement locationSelect;

    @AndroidFindBy(id="jakarta")
    private WebElement jakartaSelect;

    @AndroidFindBy(id="referralCode")
    private WebElement referralEditTextt;

    @AndroidFindBy(id="password")
    private WebElement passwordEditText;

    @AndroidFindBy(id="repassword")
    private WebElement repasswordEditText;

    @AndroidFindBy(id="pinNumber")
    private WebElement pinNumberEditText;

    @AndroidFindBy(id="userUploadProfile")
    private WebElement photoProfileWithKTP;

    @AndroidFindBy(xpath="//*[@text='Files']")
    private WebElement chooseFile;

    @AndroidFindBy(id="com.android.documentsui:id/thumbnail/ppktp.jpeg")
    private WebElement chooseFoto;

    @AndroidFindBy(id="userUploadKTP")
    private WebElement photoProfileWithKTPSelect;

    @AndroidFindBy(id="com.android.documentsui:id/thumbnail/ppktp.jpeg")
    private WebElement chooseFotoKTP;

    @AndroidFindBy(id="tnc")
    private WebElement checklistTNC;

    @AndroidFindBy(id="registrasi")
    private WebElement registrasiButton;

    @AndroidFindBy(id="confirmReg")
    private WebElement registrasiConfirmOkeButton;

    @AndroidFindBy(id="successfull")
    private WebElement successText;

    //=============================================//

    public void clickOnHyperlinkRegister() {
        appium.clickOn(registrasiHyperLink);
    }

    public void enterFullname(String fullname) {
        appium.enterText(fullnameEditText, fullname, true);
    }

    public void enterPhoneNumber(String phoneNumber) {
        appium.enterText(phoneNumberEditText, phoneNumber, true);
    }

    public void enterEmail(String email) {
        appium.enterText(emailEditText, email, true);
    }

    public void enterMothersName(String mothersName) {
        appium.enterText(mothersNameEditText, mothersName, true);
    }

    public void clickOnNationality() throws InterruptedException {
        appium.clickOn(nationalitySelect);
    }

    public void clickChooseWNI() throws InterruptedException {
        appium.clickOn(wniSelected);
    }

    public void enterCityName(String cityName) {
        appium.enterText(locationSelect, cityName, true);
    }

    public void clickOnJakartaIndoneria() {
        appium.clickOn(jakartaSelect);
    }

    public void enterCodeReferral(String codeReferral) {
        appium.enterText(referralEditTextt, codeReferral, true);
    }

    public void enterPassword(String password) {
        appium.enterText(passwordEditText, password, true);
    }

    public void enterRePassword(String rePassword) {
        appium.enterText(repasswordEditText, rePassword, true);
    }

    public void enterPinNumber(String pinNumber) {
        appium.enterText(pinNumberEditText, pinNumber, true);
    }

    public void clickOnUploadPhotoAndKTP() {
        appium.clickOn(photoProfileWithKTPSelect);
    }

    public void clickOnChooseFromGallery() {
        appium.clickOn(chooseFile);
    }

    public void clickOnChoosePhoto() throws InterruptedException{
        appium.hardWait(5);
        appium.pushFile("/sdcard/download/ppKTP.jpeg", new File("src/main/java/utilities"));
    }

    public void clickOnUploadKTP() {
        appium.clickOn(photoProfileWithKTP);
    }

    public void clickOnChoosePhotoKTP() throws InterruptedException {
        appium.hardWait(5);
        appium.pushFile("/sdcard/download/ktp.jpeg", new File("src/main/java/utilities"));
    }

    public void clickOnChecklistTnC() throws InterruptedException {
        appium.hardWait(5);
        appium.clickOn(checklistTNC);
    }

    public void clickOnRegistrasiButton() throws InterruptedException{
        appium.clickOn(registrasiButton);
    }

    public void clickOnConfirmButton() throws InterruptedException {
        appium.clickOn(registrasiConfirmOkeButton);
    }

    public String messageToastSuccess(String message) {
        return appium.getText(successText, message, true);
    }
}