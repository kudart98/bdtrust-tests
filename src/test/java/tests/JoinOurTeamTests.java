package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


@Tag("web")
public class JoinOurTeamTests extends TestBase {

    @Test
    @DisplayName("Explore careers opportunities + switching to Iframe")
    void careersOpportunitiesContainsQA() {

        open("");
        $("#menu-item-71").click();
        $(".section-splash-text").shouldHave(text("Join Our Team"));
        switchTo().frame("BrzyHr_iframe");
        $(By.linkText("Lead Quality Assurance Engineer"))
                .scrollIntoView(true)
                .shouldHave(text("Lead Quality Assurance Engineer"))
                .click();
        $$(".description")
                .shouldHave(texts("Lead Quality Assurance Engineer - Remote"))
                .shouldHave(texts("Responsibilities"))
                .shouldHave(texts("Requirements"));

    }
}