package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BercutPage;

@Tag("bercut_auto")
public class BercutTests extends TestBase {

    BercutPage bercutPage = new BercutPage();

    @Test
    @DisplayName("Проверка работоспособности глобального поиска")
    public void searchOnMainPageTest() {
        String searchText = "bss";
        bercutPage
                .openPage()
                .searchByText(searchText)
                .checkSearchResult();
    }

    @Test
    @DisplayName("Проверка страницы с контактами организации")
    public void openContactsTest() {
        bercutPage
                .openPage()
                .goToContacts()
                .checkContacts();
    }

    @Test
    @DisplayName("Проверка перехода на страницу продукта")
    public void checkMchs112ProductTest() {
        String productName = "МЧС-112";
        bercutPage
                .openPage()
                .openProducts()
                .goToProduct(productName)
                .checkProduct(productName);
    }

    @Test
    @DisplayName("Проверка переключения на другой каталог")
    public void checkCatalogSwitchingTest() {
        String catalogName = "Услуги";
        bercutPage
                .openPage()
                .switchCatalog(catalogName)
                .checkSelectedCatalog(catalogName);
    }

    @Test
    @DisplayName("Проверка поиска вакансий")
    public void checkVacanciesTest() {
        String vacancy = "qa";
        bercutPage
                .openPage()
                .goToCareer()
                .goToVacancies()
                .searchVacancy(vacancy)
                .checkSearchResult(vacancy);
    }
}
