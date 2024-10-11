package demoqa_tests;

import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    void testFrames() {
        helper.getBrowserManager().openURL("https://demoqa.com/frames");
        helper.getiFrameHelper().switchToIFrame(demoqaPages.getFramesPage().frame1);
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));

        helper.getiFrameHelper().switchToDefaultIFrame();
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().textCenter));

        helper.getiFrameHelper().switchToFrameByIndex(2);
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading));
    }
 }

