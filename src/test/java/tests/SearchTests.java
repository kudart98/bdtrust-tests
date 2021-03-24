package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Tag("web")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Search for \"who we are\"")
    void baseSearch() {

        String search = "who we are";
        open("");
        $("#gsc-i-id1").setValue(search).pressEnter();
        $$(".gsc-expansionArea").shouldHave(texts(search));
        $(".gsc-expansionArea div div div div a").click();
        String winHandleBefore = getWebDriver().getWindowHandle();
        for (String winHandle : getWebDriver().getWindowHandles()) {
            getWebDriver().switchTo().window(winHandle);
        }
        $(".founder-img")
                .scrollIntoView(true)
                .shouldBe(visible);

    }
}
