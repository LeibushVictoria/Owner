package guru.qa.tests;

import guru.qa.config.WebDriverConfig;
import guru.qa.config.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private final WebDriverConfig config =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    private final WebDriverProvider provider = new WebDriverProvider(config);

    @Test
    public void testTitle() {
        WebDriver driver = provider.get();
        driver.get(config.getBaseUrl());
        assertEquals(
                "GitHub: Where the world builds software · GitHub",
                driver.getTitle()
        );
        driver.quit();
    }
}
