Feature: PttAVM uygulamasini test eder
  @ptt
  Scenario: Kullanici uygulama testlerini yapar
    Given Kullanici uygulamayi acar
    When hesabim bolumune gider
    Then Kullanıcı "Giriş Yap" butonunun göründüğünü doğrular
    When Kullanıcı ana sayfaya geri doner
    And "Kategoriler" bolumune tiklar
    When "Beyaz Eşya" bolumunu secer
    And "Kurutma Makineleri" secenegine gider
    And Urunleri "Azalan Fiyat" a gore siralar
    Then fiyatlarin azalan duzende oldugunu dogrular

  Scenario: Kullanici ekran fotografi alma gorevini yerine getirir
    Given Kullanici uygulamayi acar
    And "Anasayfa" bolumune tiklar
    Then Kullanici ekran fotografi cekmek istedigi elementin "Bugüne Özel" ekran fotografini ceker