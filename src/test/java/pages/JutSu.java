package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JutSu {

    private final SelenideElement
            buttonChooseCategory = $("[title=\"Выбрать жанры и годы выхода аниме\"]"),
            genre = $(".anime_choose_wall .anime_ganres_are_here"),
            years = $(".anime_choose_wall .anime_years_are_here"),
            type = $(".anime_choose_wall .anime_choose_block_types"),
            sort = $(".anime_choose_wall .anime_orders_are_here"),
            buttonOk= $("[class = \"anime_choose_category_btns anime_choose_category_ok\"]"),
            search = $("#anime_fast_search");

    public JutSu openPage() {
        open("https://jut.su/anime/");
        return this;
    }

    public JutSu chooseAnimeForCategory(String genreType, String yearsType, String types, String sortType) {
        buttonChooseCategory.click();
        genre.$(byText(genreType)).click();
        years.$(byText(yearsType)).click();
        type.$(byText(types)).click();
        sort.$(byText(sortType)).click();
        buttonOk.click();
        refresh();
        return this;
    }

    public JutSu fastSearchAnime(String anime) {
        search.setValue(anime).pressEnter();
        return this;
    }
}
