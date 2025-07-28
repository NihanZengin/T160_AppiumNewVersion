package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PttPage {

    /**
     * Locate alirken DIKKAT:
     * Yeni versiyonda Appium Inspektor ile locate alirken
     asagidaki bilgiler eski versyondan farkli doldurulacak.

     * Remote Host: 127.0.0.1
     * Remote Port: 4723
     * Remote Path: /

     NOT: IntelliJ Terminalde Appium Server actiysak;
     O zaman bu bilgileri tamamen silerek Start Sessiona basabildik.
     */

    public PttPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }
    ///Constructor olusturmayi unutmayalim page sayfasinda

    @FindBy(id = "com.pttem.epttavm:id/buttonOpenAccountPage")
    public WebElement accountButton;

    @FindBy(id = "com.pttem.epttavm:id/buttonLogin")
    public WebElement girisYapButton;

    @FindBy(id = "com.pttem.epttavm:id/buttonBack")
    public WebElement geriOkButton;

    @FindBy(id = "com.pttem.epttavm:id/categories")
    public WebElement kategorilerButton;

    @FindBy(xpath = "(//*[@class='android.widget.LinearLayout'])[9]")
    public WebElement beyazEsyaButton;

    @FindBy(xpath = "(//*[@class='android.widget.LinearLayout'])[25]")
    public WebElement kurutmaMakinalariButton;


    @FindBy(xpath = "//*[@text='Azalan Fiyat']")
    public WebElement AzalanFiyatText;

    @FindBy(xpath = "//*[@text='Sırala']")
    public WebElement siralaButton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.pttem.epttavm:id/textViewProductPrice'])[2]")
    public WebElement ikinciFiyat;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id='com.pttem.epttavm:id/textViewProductPrice'])[1]")
    public WebElement ilkFiyat;

}
