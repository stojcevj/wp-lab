package mk.finki.ukim.wp.lab.selenium;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {

    private HtmlUnitDriver driver = new HtmlUnitDriver(true);

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @BeforeEach
    public void start(){
        this.driver = new HtmlUnitDriver(true);
    }

    @Test
    public void testScenario() throws Exception{
        BalloonsPage bp = BalloonsPage.to(this.driver);
        bp.assertElements(0,0,0,0);
        LoginPage lp = LoginPage.openLogin(this.driver);
        bp = LoginPage.doLogin(this.driver, lp, "admin", "admin");
        bp.assertElements(0,0,0,1);
    }

}
