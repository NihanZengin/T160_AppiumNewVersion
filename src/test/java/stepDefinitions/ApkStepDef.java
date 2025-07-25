package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.Driver;

public class ApkStepDef {

    @Given("Kullanici test etmek istedigi uygulamayi cihaza yukler")
    public void kullanici_test_etmek_istedigi_uygulamayi_cihaza_yukler() {
        Driver.getAndroidDriver();

    }
}
