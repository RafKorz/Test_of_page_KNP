import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KNPTest
{
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rafal\\Desktop\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://knp.org.pl/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest()
    {
        Assert.assertEquals(driver.getTitle(), "Kongres Nowej Prawicy");
    }

    @Test
    public void urlTest()
    {
        String url = "https://knp.org.pl/";
        Assert.assertEquals(driver.getCurrentUrl(), url);


        System.out.println("==============================================================================");
        System.out.println("Expected URL => "+url);
        System.out.println("Actual URL => "+driver.getCurrentUrl());
        System.out.println("==============================================================================");
    }

    @Test
    public void footerTest()
    {
        Assert.assertEquals(true, verifyElementPresent(driver, By.cssSelector("#copy-right > div > div > div > div > p")));
    }

    @Test
    public void headerTest()
    {
        Assert.assertEquals(true, verifyElementPresent(driver, By.cssSelector("body > knp-root > ui-navbar > header > div")));
    }

    @Test
    public void navigationProgramTest()
    {
        driver.navigate().to("https://knp.org.pl/program");
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("/html/body/knp-root/main/knp-program/div/ui-card[1]/div/div/h1")));
    }

    @Test
    public void navigationConstitutionProjectTest()
    {
        driver.navigate().to("https://knp.org.pl/projekt-konstytucji");
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("/html/body/knp-root/main/knp-constitution-draft/div/div/div[2]/ui-card[1]/div/div/h2")));
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("/html/body/knp-root/main/knp-constitution-draft/div/div/div[1]/a/ui-button/button")));
    }

    @Test
    public void navigationJoinUsTest()
    {
        driver.navigate().to("https://knp.org.pl/dolacz");
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("/html/body/knp-root/main/knp-join-us/div/div/div/div[1]/h1")));
    }

    @Test
    public void navigationSupportUsTest()
    {
        driver.navigate().to("https://knp.org.pl/wspieraj");
        Assert.assertEquals(true, verifyElementPresent(driver, By.xpath("/html/body/knp-root/main/knp-donation/div/div/div/div[1]/h1")));
    }

    public static boolean verifyElementPresent(WebDriver driver, By by)
    {
        try{
            driver.findElement(by);
            System.out.println("Element found");
            return true;
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
