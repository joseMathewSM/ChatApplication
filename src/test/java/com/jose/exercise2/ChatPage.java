package com.jose.exercise2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.awt.*;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement msgTextField;

    @FindBy(id = "messageType")
    private Select msgTypeDropdown;

    @FindBy(css = "input[type=submit]")
    private WebElement submitButton;

    @FindAll({ @FindBy(css = "td")})
    private List<WebElement> elems;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void publishMsg(String msgText, String type){
        msgTextField.sendKeys(msgText);
        //msgTypeDropdown.selectByValue("Say");
        submitButton.click();
    }

    public void validateMsg(String msgText){
        boolean val = false;
        for (WebElement e: elems) {
            System.out.println(e.getText());
            if(e.getText().equals(msgText)) {
                val = true;
                break;
            }
        }
        assert val == true;
    }
}
