package uni.pu.fmi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.service.OutfitService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateOutfitSteps {

    private final CreateOutfitHelperModel helperModel = new CreateOutfitHelperModel();

    @Given("потребителя е логнат")
    public void loggedUser() {
        helperModel.setUserId(1L);
    }

    @When("потребителя въвежда име {string}, описание {string}, снимка {string}")
    public void createContent (String name, String description, String photo) {
        helperModel.setName(name);
        helperModel.setDescription(description);
        helperModel.setPhoto(photo);
    }

    @And("натиска бутона за създаване")
    public void clickCreateButton() {
        OutfitService outfitService = new OutfitService();
        outfitService.createOutfit(helperModel.getName(), helperModel.getDescription(), helperModel.getPhoto(), helperModel.getUserId());
    }

    @Then("успешно създаване на съдържание")
    public void successfullyCreated() {
        assertNotNull(helperModel);
    }

    @Then("вижда съобщение {string}")
    public void errorMessage(String expectedMessage) {
        assertEquals(expectedMessage, helperModel.validateContentData());
    }
}
