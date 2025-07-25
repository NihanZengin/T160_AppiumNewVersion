package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PttPage {
    public PttPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }
    @FindBy(id = "com.pttem.epttavm:id/buttonOpenAccountPage")
    public WebElement accountButton;

    @FindBy(id = "com.pttem.epttavm:id/buttonLogin")
    public WebElement girisYapButton;

    @FindBy(id = "com.pttem.epttavm:id/buttonBack")
    public WebElement geriOkButton;

    @FindBy(id = "com.pttem.epttavm:id/categories")
    public WebElement kategorilerButton;

    @FindBy(xpath = "//*[@text='Azalan Fiyat']")
    public WebElement AzalanFiyatText;

    @FindBy(xpath = "//*[@text='Sırala']")
    public WebElement siralaButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement ikinciFiyat;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[7]")
    public WebElement ilkFiyat;

}
