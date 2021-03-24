package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Tag("web")
public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Page should have text \"Transforming Benefits Access\" ")
    void titlePageTest() {
        open("");
        $x("//h2[@class='sectiontitle highlight-lastword']")
                .scrollIntoView(true)
                .shouldHave(text("Transforming Benefits Access"));
    }

    @Test
    @DisplayName("Base header buttons was loaded")
    void headerButtonsLoaded() {
        open("");
        $("#menu-item-34").shouldBe(visible).shouldHave(text("Who We Are"));
        $("#menu-item-33").shouldBe(visible).shouldHave(text("What We Do"));
        $("#menu-item-32").shouldBe(visible).shouldHave(text("Our Partners"));
        $("#menu-item-31").shouldBe(visible).shouldHave(text("Where We Work"));
        $("#menu-item-30").shouldBe(visible).shouldHave(text("In The News"));
    }

    @Test
    @DisplayName("Footer contain the actual year")
    void footerCopyrightContainActualYear() {
        open("");
        $(".copyright")
                .scrollIntoView(true)
                .shouldHave(text("2021"));
    }
}
