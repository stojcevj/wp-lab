package mk.finki.ukim.wp.lab.selenium;

import mk.finki.ukim.wp.lab.model.Balloon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{

        private WebElement user;

        private WebElement password;

        private WebElement submit;

        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public static LoginPage openLogin(WebDriver driver) {
            get(driver, "/login");
            System.out.println(driver.getCurrentUrl());
            return PageFactory.initElements(driver, LoginPage.class);

        }

        public static BalloonsPage doLogin(WebDriver driver, LoginPage loginPage, String username, String password) {
            loginPage.user.sendKeys(username);
            loginPage.password.sendKeys(password);
            loginPage.submit.click();
            System.out.println(driver.getCurrentUrl());
            return PageFactory.initElements(driver, BalloonsPage.class);
        }

        public static LoginPage logout(WebDriver driver) {
            get(driver, "/logout");
            return PageFactory.initElements(driver, LoginPage.class);
        }
    }