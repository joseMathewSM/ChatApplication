package com.jose.exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement usernameTxtField;

    @FindBy(id = "inputPassword")
    private WebElement passwordTxtField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String username, String password){
        usernameTxtField.sendKeys(username);
        passwordTxtField.sendKeys(password);
        submitButton.click();
    }

}
