package pages.component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    public ResultComponent checkWorkFilters(String genreType, String yearsType, String types) {
        $("#dle-content .mailBlock_h").shouldHave(text("Аниме жанра " +  genreType + " типа " + types + " " + yearsType + " года"));
        return this;
    }
    public ResultComponent checkFastSearch(String anime) {
        $("[class=\"all_anime_content anime_some_margin\"]").shouldHave(text(anime));
        return this;
    }
}
