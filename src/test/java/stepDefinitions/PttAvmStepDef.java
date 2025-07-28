package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.PttPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class PttAvmStepDef {

    /// Locateleri kullanabilmek icin PttPage class'ini obje olustur
    PttPage page=new PttPage();

    @Given("Kullanici uygulamayi acar")
    public void kullanici_uygulamayi_acar() {
        Driver.getAndroidDriver();
    }

    @When("hesabim bolumune gider")
    public void hesabim_bolumune_gider() {
        page.accountButton.click();
        ReusableMethods.bekle(3);
    }

    @Then("Kullanıcı {string} butonunun göründüğünü doğrular")
    public void kullanıcı_butonunun_göründüğünü_doğrular(String GirisYap) {
        Assert.assertTrue(page.girisYapButton.isDisplayed());
        ReusableMethods.bekle(3);
    }

    @When("Kullanıcı ana sayfaya geri doner")
    public void kullanıcı_ana_sayfaya_geri_doner() {
        page.geriOkButton.click();
        ReusableMethods.bekle(3);
    }

    @When("{string} bolumune tiklar")
    public void bolumune_tiklar(String secenek) {
         page.kategorilerButton.click();
        //ReusableMethods.scrollWithUiScrollableAndClick(secenek);
        //Bu method text ile locate aldigi icin
        // feature class'da string olarak Kategoriler yazinca buna tiklayabiliyor.
        ReusableMethods.bekle(3);
    }

    @When("{string} bolumunu secer")
    public void bolumunu_secer(String urunkategorisi) {
        //ReusableMethods.scrollWithUiScrollableAndClick(urunkategorisi); //text olarak yine locate gelecek.(beyaz esya)
        //Yukardaki calismadi gene
        page.beyazEsyaButton.click();
        ReusableMethods.bekle(3);
    }

    @When("{string} secenegine gider")
    public void secenegine_gider(String urun) {
        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.70,0.30,0.50,80);
        /// telefonun %70 lik y kordinatindan %30 lik y kordinatina kadar kaydir
        /// x kordinati da tam orta nokta olan %50 olsun
        /// ve buradaki sure ne kadar fazla olursa yavas kaydirma anlamina gelir ki, listede az iner
        ///ama az sure yazarsak bu hizli kaydirir ve listenin sonuna kadar gelir. Biz 80 yaptik
        ReusableMethods.bekle(3);
        //ReusableMethods.scrollWithUiScrollableAndClick(urun);
        page.kurutmaMakinalariButton.click();
        ReusableMethods.bekle(3);

    }
    @When("Urunleri {string} a gore siralar")
    public void urunleri_a_gore_siralar(String string) {
        page.siralaButton.click();
        ReusableMethods.bekle(3);
        page.AzalanFiyatText.click();
        ReusableMethods.bekle(3);

    }
    @Then("fiyatlarin azalan duzende oldugunu dogrular")
    public void fiyatlarin_azalan_duzende_oldugunu_dogrular() {
        ReusableMethods.bekle(3);
        String ilkfiyat= page.ilkFiyat.getText();
        ilkfiyat=ilkfiyat.replaceAll("\\D","");

        ReusableMethods.bekle(3);

        String ikincifiyat= page.ikinciFiyat.getText();
        ikincifiyat=ikincifiyat.replaceAll("\\D","");

        Assert.assertTrue(Long.parseLong(ilkfiyat)<Long.parseLong(ikincifiyat));

    }
    @Then("Kullanici ekran fotografi cekmek istedigi elementin {string} ekran fotografini ceker")
    public void kullanici_ekran_fotografi_cekmek_istedigi_elementin_ekran_fotografini_ceker(String ekranGoruntusu) throws IOException {
        ReusableMethods.bekle(7);
        ReusableMethods.screenShotElement(ekranGoruntusu);

    }

}
