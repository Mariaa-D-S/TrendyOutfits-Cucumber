package uni.pu.fmi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.models.Outfit;
import uni.pu.fmi.service.OutfitService;

import java.util.List;

import static org.junit.Assert.*;

public class SearchOutfitSteps {

    private final SearchOutfitHelperModel helperModel;

    public SearchOutfitSteps(SearchOutfitHelperModel helperUserModel) {
        this.helperModel = helperUserModel;
    }

    @When("отваряне на приложението")
    public void openApp() {
        //missing real app
    }

    @When("потребителя въвежда ключова дума {string} в полето за търсене")
    public void searchByKeyword(String keyword) {
        helperModel.setSearchKeyword(keyword);
    }

    @And("натиска бутона за търсене")
    public void clickSearchButton() {
        OutfitService outfitService = new OutfitService();
        List<Outfit> foundOutfits = outfitService.searchOutfits(helperModel.getSearchKeyword());
        helperModel.setOutfitList(foundOutfits);
    }

    @Then("Визуализира се списък с наличните аутфити")
    public void viewOutfits() {
        List<Outfit> outfits = helperModel.getOutfitList();
        if (outfits == null) {
            OutfitService outfitService = new OutfitService();
            outfitService.load();
        }

    }

    @Then("Неуспешно търсене")
    public void unsuccessfulSearch() {
        List<Outfit> outfits = helperModel.getOutfitList();
        assertTrue(outfits.isEmpty());
    }

    @Then("Вижда съобщение {string}")
    public void errorMessage(String expectedMessage) {
        assertEquals(expectedMessage, helperModel.errorMessage(helperModel.getSearchKeyword()));
    }
}
