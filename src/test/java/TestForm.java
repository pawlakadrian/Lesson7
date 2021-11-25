import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestForm extends TestBase {

    @Test
    @DisplayName("Test formularza")
    void testForm() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Adrian");

        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.sendKeys("Pawlak");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail3"));
        email.sendKeys("apawlak1@sii.pl");

        List<WebElement> sexRadio = driver.findElements(By.cssSelector(".form-check [name='gridRadiosSex']"));
        Random random = new Random();
        int sexRadioIndex = random.nextInt(sexRadio.size());
        sexRadio.get(sexRadioIndex).click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("30");

        List<WebElement> yearOfExp = driver.findElements(By.cssSelector(".form-check [name='gridRadiosExperience']"));
        int yearOfExpIndex = random.nextInt(yearOfExp.size());
        yearOfExp.get(yearOfExpIndex).click();

        WebElement profession = driver.findElement(By.cssSelector("#gridCheckAutomationTester"));
        profession.click();

        Select continents = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        List<WebElement> continentsList = driver.findElements(By.cssSelector(".form-check [name='gridRadiosExperience']"));
        int continentsIndex = random.nextInt(continentsList.size());
        continents.selectByIndex(continentsIndex);

        WebElement seleniumCommands1 = driver.findElement(By.cssSelector(".custom-select [value='switch-commands']"));
        WebElement seleniumCommands2 = driver.findElement(By.cssSelector(".custom-select [value='wait-commands']"));
        seleniumCommands1.click();
        seleniumCommands2.click();

        WebElement uploadFile = driver.findElement(By.cssSelector("#chooseFile"));
        File file = new File("src/resources/sample.pdf");
        uploadFile.sendKeys(file.getAbsolutePath());

        //---------------------
        File dir = new File("src" + File.separator + "download");
        int actualDirFiles;

        if (dir != null && dir.length() > 0) {
            actualDirFiles = dir.listFiles().length;
        } else {
            actualDirFiles = 0;
        }

        //---------------------
        WebElement downloadBtn = driver.findElement(By.linkText("Test File to Download"));
        downloadBtn.click();

        //---------------------
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        submitBtn.click();

        //---------------------
        int dirFilesIsIncr = dir.listFiles().length;

        assertThat(actualDirFiles + 1, equalTo(dirFilesIsIncr));

        //---------------------
        WebElement validateMsg = driver.findElement(By.cssSelector("#validator-message"));
        String msgToValidate = "Form send with success";
        assertThat(validateMsg.getText(), equalTo(msgToValidate));
    }
}
