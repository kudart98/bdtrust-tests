package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Tag("web")
public class GetHelpTests extends TestBase {

    @Test
    @DisplayName("Search result for 19115")
    void getHelpByZip() {

        String zip = "19115";
        String finalSearch = "BenePhilly is a free program that helps low-income Philadelphians enroll in critical benefits and services.";
        open("");
        $(".get-help-link").click();
        $("#Search").setValue(zip).pressEnter();
        $x("//a[normalize-space()='Learn More']").click();
        $x("//h3[contains(text(),'BenePhilly is a free program that helps low-income')]")
                .shouldHave(Condition.text(finalSearch));

    }

    @Test
    @DisplayName("Search result Error message")
    void getHelpByWrongZip() {

        String zip = "12354ff";
        String errorMessage = "Thank you for visiting Benefits Data Trust. We do not currently serve your area. We have locations in Pennsylvania, New York, North Carolina, South Carolina, Maryland and Colorado.";
        open("");
        $(".get-help-link").click();
        $("#Search").setValue(zip).pressEnter();
        $x("//h3[contains(text(),'Thank you for visiting Benefits Data Trust. We do ')]")
                .shouldHave(Condition.text(errorMessage));

    }
}
