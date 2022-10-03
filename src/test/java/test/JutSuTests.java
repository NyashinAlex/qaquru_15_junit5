package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.JutSu;
import pages.component.ResultComponent;

import java.util.List;
import java.util.stream.Stream;

public class JutSuTests {
    JutSu jutSu = new JutSu();
    ResultComponent resultComponent = new ResultComponent();
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @CsvSource(value = {
            "Комедия, 2021, Школа, По алфавиту",
            "Драма, 2020, История, По дате добавл."
    })
    @ParameterizedTest(name = "Sorting anime by filters")
    void sortingAnimeByFilters(String genreType, String yearsType, String types, String sortType) {
        jutSu.openPage()
                .chooseAnimeForCategory(genreType, yearsType, types, sortType);
        resultComponent.checkWorkFilters(genreType, yearsType, types);
    }
    @ValueSource(strings = {"Атака титанов", "Ванпанчмен"})
    @ParameterizedTest(name = "Search anime {0}")
    void searchFastAnime(String testData) {
        jutSu.openPage().fastSearchAnime(testData);
        resultComponent.checkFastSearch(testData);
    }

    static Stream<Arguments> buttonsTextsInHeader() {
        return Stream.of(
                Arguments.of(List.of("Типы", "Вода", "Молния", "Земля", "Ветер", "Огонь", "Чакра"))
        );
    }

    @MethodSource("buttonsTextsInHeader")
    @ParameterizedTest(name = "Проверка отображения названия кнопок в хедере")
    void checkButtonsTextsInHeader(List<String> buttonsTexts) {
        jutSu.openPage();
        resultComponent.checkButtonInHeader(buttonsTexts);
    }
}
