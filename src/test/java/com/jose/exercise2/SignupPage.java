package com.jose.exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(id = "inputFirstName")
    private WebElement fnameTxtField;

    @FindBy(id = "inputLastName")
    private WebElement lnameTxtField;

    @FindBy(id = "inputUsername")
    private WebElement userNameTxtField;

    @FindBy(id = "inputPassword")
    private WebElement passwordTxtField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMsg;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void signupUser(String fname, String lname, String username, String password)
    {
        fnameTxtField.sendKeys(fname);
        lnameTxtField.sendKeys(lname);
        userNameTxtField.sendKeys(username);
        passwordTxtField.sendKeys(password);
        submitButton.click();
    }

    public void validateSuccessfullSignup(){
        successMsg.getText().contains("You successfully signed up!");
    }

}
