package internal.example.selenide.google;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {


    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = BrowserType.CHROME;
    }

    @Test
    public void test1() throws Exception {

        open("http://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#ires .g").shouldHave(size(10));
        $("#ires .g").shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org"));

    }
}
