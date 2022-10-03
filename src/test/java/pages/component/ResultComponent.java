package pages.component;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ResultComponent {

    public ResultComponent checkWorkFilters(String genreType, String yearsType, String types) {
        $("#dle-content .mailBlock_h").shouldHave(text("Аниме жанра " +  genreType + " типа " + types + " " + yearsType + " года"));
        return this;
    }
    public ResultComponent checkFastSearch(String anime) {
        $("[class=\"all_anime_content anime_some_margin\"]").shouldHave(text(anime));
        return this;
    }
    public ResultComponent checkButtonInHeader(List<String> button) {
        $$x("//div[@class='top_nav_b']/*/li").shouldBe(CollectionCondition.texts(button));
        return this;
    }
}
