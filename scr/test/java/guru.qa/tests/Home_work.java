
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
     void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Grishina");
        $("#userEmail").setValue("aaa@aa.aa");
        $(byText("Female")).click();
        $("#userNumber").setValue("8912345678");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1988");
        $(byText("29")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("simple.txt");
        $("#currentAddress").setValue("Krasnaya, 1-1-11");
        $("#state").setValue("NCR").pressEnter();
        $("#city").setValue("Delhi").pressEnter();
        $("#submit").click();
    }

    void checkResult() {
        $(byText("Thanks for submitting the form")).should(appear);
        $(byText("Anna Grishina")).should(appear);
        $(byText("aaa@aa.aa")).should(appear);
        $(byText("Female")).should(appear);
        $(byText("8912345678")).should(appear);
        $(byText("29 March,1988")).should(appear);
        $(byText("Test")).should(appear);
        $(byText("Sports")).should(appear);
        $(byText("simple.txt")).should(appear);
        $(byText("Krasnaya, 1-1-11")).should(appear);
        $(byText("NCR Delhi")).should(appear);
    }
}