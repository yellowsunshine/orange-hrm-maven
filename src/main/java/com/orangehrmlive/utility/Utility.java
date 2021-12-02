package com.orangehrmlive.utility;

import com.orangehrmlive.drivermanager.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;

public class Utility extends DriverManager {
    /**
     *****************BASIC WEBDRIVER METHODS******************************
     */

    /**
     * This method will click on element
     *
     * @ param by
     */
    public void doClickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will find the element and clear all the data from it
     *
     * @param by
     */
    public void doFindElementAndClearText(By by) {
        WebElement elementToClear = driver.findElement(by);
        elementToClear.clear();
    }

    /**
     * This method will get text from element
     *
     * @param by
     * @return
     */
    public String doGetTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will extract the value of a particular attribute from an element
     *
     * @param by
     * @param attribute
     * @return
     */
    public String doGetAttributeFromElement(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    /**
     * This method will send text to an element
     *
     * @param by
     * @param text
     */
    public void doSendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);//
    }

    /**
     * ***********ALERT METHODS***************************
     */

    /**
     * This method will switch to an Alert from main window
     */
    public void doSwitchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will switch to an alert from main window and click on the 'OK' button of the alert
     */
    public void doAcceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss an alert
     */
    public void doDismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will switch to an alert from main window and capture text from it
     *
     * @return
     */
    public String doGetTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * This method will send some data to the alert box
     *
     * @param textToSend
     */
    public void doSendTextToAlert(String textToSend) {
        driver.switchTo().alert().sendKeys(textToSend);
    }


    /**
     * ***************SELECT CLASS METHODS***************
     * **************SELECTS FROM DROPDOWNS*****************
     */

    /**
     * This method will select the option that matches the display text passed as parameter
     *
     * @param by
     * @param text
     */
    public void doSelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method selects the option whose value matches the specified parameter
     *
     * @param by
     * @param value
     */
    public void doSelectByValue(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method selects the option at the given index position
     *
     * @param by
     * @param index
     */
    public void doSelectByIndex(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    /**
     * This method will get all elements from the dropdown list and print in console
     *
     * @param by
     */
    public void doSelectGetOptionsAndPrint(By by) {
        Select optionsSelect = new Select(driver.findElement(by));
        List<WebElement> optionNames = optionsSelect.getOptions();
        for (int i = 0; i < optionNames.size(); i++) {
            System.out.println(optionNames.get(i).getText());
        }
    }

    /**
     * THIS METHOD SELECTS A PARTICULAR MENU FROM THE MENU BAR
     *
     * @param by
     * @param menu
     * @throws InterruptedException
     */

    public void selectMenu(By by, String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }

    /**
     * ************ACTION CLASS  METHODS******************
     * *******PERFORMS MOUSE/KEYBOARD ACTIONS******************
     */

    /**
     * This method hovers mouse over an element and does not click
     *
     * @param by
     */

    public void doMouseHoverNoClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).build().perform();
    }

    /**
     * This method will hover the mouse over a particular element and click it
     *
     * @param by
     */
    public void doMouseHoverAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    /**
     * This Method will hover mouse on one element, then on second element
     * and click the second element
     */
    public void doMouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location
     *
     * @param by
     */
    public void doRightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick().build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse
     *
     * @param source
     * @param target
     */
    public void doDragAndDrop(By source, By target) {
        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position
     *
     * @param sliderBar
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void doSliderMovement(By sliderBar, By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement mainSlider = driver.findElement(sliderBar);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }

    /**
     * *******************RANDOM EMAIL GENERATOR*****************************
     */
    /**
     * This method generated a random email
     *
     * @return
     */

    public String doRandomStringGenerator() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890$%^&£^ABCDEFG";
        StringBuilder stringBuilder = new StringBuilder();
        Random randomString = new Random();
        while (stringBuilder.length() < 10) {
            int index = (int) (randomString.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        String saltStr = (stringBuilder.toString());
        return saltStr;
    }

    /**
     * ******************VERIFICATION METHODS---ASSERT CLASS**********************
     */

    /**
     * This method verifies elements using Assert class after reading text from element
     *
     * @param expectedMessage
     * @param actualMessage
     * @param displayMessage
     */

    public void doVerifyElements(String expectedMessage, String actualMessage, String displayMessage) {
        Assert.assertEquals(expectedMessage, actualMessage, displayMessage);
    }

    /******
     * This method verifies elements using locator directly as the second
     * instead of String
     * @param expectedMessage
     * @param by
     * @param displayMessage
     */

    public void doVerifyElements(String expectedMessage, By by, String displayMessage) {
        Assert.assertEquals(expectedMessage, by, displayMessage);
    }

    /**
     * This method is getting text from actual Message's WebElement using
     * the Explicit Wait Method. We will then use this as String actualMessage in Verification Method
     * We have used "waitUntilVisibilityOfElementLocated" Explicit Wait Method here
     * @param actualMessage
     * @param timeout
     * @return
     */

    public String doGetTextFromActualMessageForVerificationUsingWait(By actualMessage, int timeout) {
        String verify = doWaitUntilVisibilityOfElementLocated(actualMessage, timeout).getText();
        return verify;
    }

    /**
     * THIS IS THE VERIFICATION METHOD USING WAIT
     * THIS METHOD WILL WORK IN THE FOLLOWING WAY:
     * 1. Get Expected - can also use the "waitUntilTitleIsEqualTo" explicit wait method.
     * 2. Get Acutal = By getting text from actual element using "waitUntilVisibilityOfElement" method
     * 3. All this incorporated in the Assert Method
     * @param expectedMessage
     * @param theActualMessage
     * @param timeForWait
     */
    public void verificationMethodUsingWait(String expectedMessage, By theActualMessage, int timeForWait) {
        String expected = expectedMessage;
        String actual = doGetTextFromActualMessageForVerificationUsingWait(theActualMessage, timeForWait);
        doVerifyElements(expected, actual, "Message is displayed incorrectly");
    }

    /************ WAIT METHODS *******************************
     * This method will Wait until the given element is visible
     * @param by
     * @param timeout
     * @return
     */

    public WebElement doWaitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public String doWaitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }


    /**
     * This method will wait for an element using Fluent Wait
     *
     * @param by
     * @param time
     * @param pollingTime
     * @return
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }


    /**********************SORTING METHODS************************
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE LOW TO HIGH
     * @param dropDown
     */

    public void verifyTheSortingOrderOfPriceLowToHighIsCorrect(By beforeFilterElements, By dropDown, By lowToHigh) {
        List<WebElement> beforeFilterWebElementPrice = driver.findElements(beforeFilterElements);
        List<Double> beforeFilterDoublePriceList = new ArrayList<>();
        for (WebElement p : beforeFilterWebElementPrice) {
            beforeFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }
        //Select dropDownBox = new Select(driver.findElement(dropDown));
        //dropDownBox.selectByVisibleText("Price Low - High");
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(lowToHigh);

        List<WebElement> afterFilterWebElementPriceList = driver.findElements(beforeFilterElements);
        List<Double> afterFilterDoublePriceList = new ArrayList<>();

        for (WebElement p : afterFilterWebElementPriceList) {
            afterFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }

        Collections.sort(beforeFilterDoublePriceList);
        Assert.assertEquals(beforeFilterDoublePriceList, afterFilterDoublePriceList, "List is not sorted according to price Low to High");
    }

    /**
     *THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE HIGH TO LOW
     * @throws InterruptedException
     */

    public void verifyIfProductsAreSortedByPriceHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList, Collections.reverseOrder());
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(hToLow);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$", "")));
        }
        System.out.println(afterSortingProductPrice);
        Assert.assertEquals(originalProductPriceList, afterSortingProductPrice, "products are not sorted");

    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF STAR RATINGS HIGH TO LOW
     * @param beforeFilterElements
     * @param dropDown
     * @param hToLow
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedAccordingToRatingHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating :originalList) {
            originalProductRating.add(rating.getAttribute("style").indexOf(3, 6));
        }

        Collections.sort(originalProductRating,Collections.reverseOrder());
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(hToLow);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 :afterSortingList){
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals(originalProductRating,afterSortingProductRating,"products are not sorted");

    }


    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM A TO Z
     * @param beforeFilterElements
     * @param dropDown
     * @param aToZ
     * @throws InterruptedException
     */
    public void verifyProductsAreSortedAlphabeticallyFromAToZ(By beforeFilterElements, By dropDown, By aToZ) throws InterruptedException {

        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductRatingList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRatingList.add(product.getText());
        }
        Collections.sort(originalProductRatingList);
        System.out.println(originalProductRatingList);

        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(aToZ);

        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals(originalProductRatingList, afterSortingProductName, "Products are not sorted");
    }

    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM Z TO A
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedFromZtoA(By beforeFilterElements, By dropDown, By zToA) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(beforeFilterElements);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        System.out.println("Expected Result is : " + originalProductNameList);
        doMouseHoverNoClick(dropDown);
        doMouseHoverAndClick(zToA);
        Thread.sleep(3000);


        List<WebElement> afterSortingList = driver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProductName.add(product1.getText());
        }
        System.out.println("actual result is : )" + afterSortingProductName);

        Assert.assertEquals(originalProductNameList, afterSortingProductName, "products are now sorted");

    }

    //Method that captures the top menu bar and then takes menu name as parameter to open the page
    // public void selectMenu(String menuName) throws InterruptedException {
    //List<WebElement> names = homePage.getTopMenuNames(menuName);
    // for (WebElement name : names) {
    //if (name.getText().equalsIgnoreCase(menuName)) {
    //name.click();
    // break;
    // }
    //  }
    // }

}
