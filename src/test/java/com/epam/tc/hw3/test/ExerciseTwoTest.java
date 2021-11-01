package com.epam.tc.hw3.test;

import static com.epam.tc.hw2.AssertsData.LOGS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.config.BaseTest;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseTwoTest extends BaseTest {

    @Test
    public void secondTest() {
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("SERVICE")).click();
        driver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();
        assertThat(driver.getTitle()).isEqualTo("Different Elements");

        //6. Select checkboxes Water, Wind
        driver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        driver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();

        //7. Select radio Selen
        driver.findElement(By.xpath("//label[@class='label-radio'][4]")).click();

        //8. Select in dropdown Yellow
        driver.findElement(By.xpath("//select[@class='uui-form-element']")).click();
        driver.findElement(By.xpath("//option[text()='Yellow']")).click();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logTxts = driver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"));
        assertThat(logTxts.stream().map(e -> e.getText().substring(e.getText().indexOf(' ') + 1))
                          .collect(Collectors.toList())).isEqualTo(LOGS);
    }
}