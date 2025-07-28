
# Appium yeni versionda calisirken kodlarimin sanal telefona itelibilmesi icin
# artik Android Server kullanmiyorum.
# Onun yerine CMD ekraninda onceden kurdugum Appium yeni versiyonu calistirip
# sonra kodlarimi calistiriyorum ki telefonumla baglanti saglansin.
Feature: Kullanici uygulamayi yukler
  @apk
  Scenario: Kullanici uygulamayi yukler
    Given Kullanici test etmek istedigi uygulamayi cihaza yukler