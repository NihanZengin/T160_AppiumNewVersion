package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static org.openqa.selenium.By.xpath;

public class ReusableMethods {

    /**
     * Appium yeni versiyonda calisirken onceki bazi reusable methodlarda duzenlemeler yaptik.
     * findByElement yerine findElement() kullandik.
     * androidUIAutomator kullandik.
     * Ekran kaydirma methodunu artik kullanamiyorum. TouchAction  olmadigi icin
     * Onun yerine dikeyKaydirma methodunu yazdik asagida...*/

    public static void koordinatTiklamaMethodu(int xkoordinati, int ykoordinati, int beklemesuresi) throws InterruptedException {

        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xkoordinati,ykoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemesuresi)))
                .release()
                .perform();

    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
        driver.findElement(xpath("//*[@text='" + elementText + "']")).click();
    }

    public static void scrollWithUiScrollable(String elementText){
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void bekle(int saniye) {

        try {

            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {
            System.out.println("Thread.sleep komutu calismadi");
        }

    }



    public static void scrollDown(int startX, int startY, int endY, int durationMs) {
        try {
            TouchAction<?> action = new TouchAction<>(Driver.getAndroidDriver());
            action
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationMs)))
                    .moveTo(PointOption.point(startX, endY))
                    .release()
                    .perform();
        } catch (Exception e) {
            System.out.println("Scroll down işlemi başarısız oldu: " + e.getMessage());
            e.printStackTrace();
        }
    }


//    public static void ekranKaydirmaMethodu(int xbaslangic, int ybaslangic, int beklemesuresi, int xbitis, int ybitis) throws InterruptedException {
//
//        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
//        action.press(PointOption.point(xbaslangic,ybaslangic))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemesuresi)))
//                .moveTo(PointOption.point(xbitis,ybitis))
//                .release()
//                .perform();
//    }

    public static void dikeyKaydirma(RemoteWebDriver driver, double baslangicYuzdesi, double bitisYuzdesi, double sabitYuzde, int sure) {
        // 1. WebDriver'ın pencere boyutunu alır
        Dimension boyut = driver.manage().window().getSize();
        // 2. Sabit noktanın x koordinatını hesaplar (pencere genişliğinin belirtilen yüzdesi)
        int sabitNokta = (int) (boyut.width * sabitYuzde);
        // 3. Başlangıç noktasının y koordinatını hesaplar (pencere yüksekliğinin başlangıç yüzdesi)
        int baslangicNoktasi = (int) (boyut.height * baslangicYuzdesi);
        // 4. Bitiş noktasının y koordinatını hesaplar (pencere yüksekliğinin bitiş yüzdesi)
        int bitisNoktasi = (int) (boyut.height * bitisYuzdesi);
        // 5. Yeni bir PointerInput (parmak girişi) oluşturur, türü TOUCH (DOKUNMA) ve adı "finger"
        PointerInput parmak = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        // 6. Kaydırma işlemi için bir Sequence (dizi) oluşturur, 1 adımlı
        Sequence kaydirma = new Sequence(parmak, 1)
                // Başlangıç noktasına parmağı hareket ettirme eylemi ekler
                .addAction(parmak.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sabitNokta, baslangicNoktasi))
                // Parmak basma (dokunma) eylemi ekler
                .addAction(parmak.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // Belirtilen süre boyunca parmağı belirtilen bitiş noktasına hareket ettirme eylemi ekler
                .addAction(parmak.createPointerMove(Duration.ofMillis(sure), PointerInput.Origin.viewport(), sabitNokta, bitisNoktasi))
                // Parmak kaldırma (dokunmayı sonlandırma) eylemi ekler
                .addAction(parmak.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // 7. Oluşturulan kaydırma işlemini WebDriver üzerinde gerçekleştirir
        driver.perform(Collections.singletonList(kaydirma));
    }
    public static void screenShotElement(String text) throws IOException {
        WebElement element = Driver.getAndroidDriver().findElement(xpath("//*[@text='"+text+"']"));
        org.openqa.selenium.Point location = element.getLocation();
        Dimension size = element.getSize();

        // Ekran görüntüsünü alın ve belirli bölgeyi kırpın
        File screenshot = Driver.getAndroidDriver().getScreenshotAs(OutputType.FILE);
        BufferedImage fullImage = ImageIO.read(screenshot);
        BufferedImage croppedImage = fullImage.getSubimage(location.getX(), location.getY(), size.getWidth(), size.getHeight());

        // Kırpılmış görüntüyü kaydedin
        File output = new File("kırpılmış_screenshot.png");
        ImageIO.write(croppedImage, "png", output);

        // Bağlantıyı kapat
        Driver.quitAppiumDriver();
    }
}
