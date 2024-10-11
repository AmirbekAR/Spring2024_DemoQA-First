package demoqa.helper;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;

public class BrowserManager {

    private WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(final String url) {
        driver.navigate().to(url);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }


    public static class WindowHelper {
        private WebDriver driver;
        private WebDriverWait wait;

        public WindowHelper(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public Set<String> getWindowHandles() {
            return driver.getWindowHandles();
        }

        public void switchToWindow(int index) {
            LinkedList<String> windowsIds = new LinkedList<>(getWindowHandles());
            if (index < 0 || index >= windowsIds.size()) {
                throw new IndexOutOfBoundsException("Index out of bounds: " + index);
            }
            driver.switchTo().window(windowsIds.get(index));
        }

        public void switchToDefaultWindow() {
            LinkedList<String> windowsIds = new LinkedList<>(getWindowHandles());
            driver.switchTo().window(windowsIds.get(0));
        }

        public void switchToParentWithChildClose(){ // переключиться к главному родительскому и закрыть все остальные окна
            switchToDefaultWindow();
            LinkedList<String> windowsIds = new LinkedList<>(getWindowHandles());
            for (int i = 0; i < windowsIds.size(); i++) {
                driver.switchTo().window(windowsIds.get(i));
                driver.close();
            }
        }
        //TODO add new method which will close the selected tab
    }

    public static class IFrameHelper {
        private WebDriver driver;
        private WebDriverWait wait;

        public IFrameHelper(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public IFrameHelper switchToIFrame(WebElement element) { // этот метод позволяет переключаться между фреймами, то есть между рекламами в примере
            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            }catch (TimeoutException e){
                e.printStackTrace();
            }
            return this;
        }

        public IFrameHelper switchToDefaultIFrame() {   // переключиться на родительский iFrame
            driver.switchTo().parentFrame();
            return this;
        }

        public IFrameHelper switchToFrameByIndex(int index) {   // переключаться по индексам между iFrame
            driver.switchTo().frame(index);
            return this;
        }

        public WebDriver getDriver() {
            return driver;
        }
    }
}
