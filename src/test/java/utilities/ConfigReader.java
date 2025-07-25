package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
     /*
        Bu class'in 2 temel gorevi var
        1- configuration.properties dosyasindaki bilgileri okumak
           ConfigReader calistirildiginda ONCELIKLE bu okuma isleminin yapilmasi icin
           okuma islemini bir static blok icerisinde yapiyoruz

           static blok calistiginda
           configuration.properties dosyasindaki tum key - value ikililerini okuyup
           class level'da bulunan "properties" objesine yukluyor

        2- ilk gorevde configuration.properties dosyasindaki
           tum key - value ikilileri okunup properties objesine yuklendi

           getProperty(istenenKey) method'u ise
           properties objesine yuklenen key-value'lerden
           bizim verecegimiz key'in karsiligindaki value'yu alip
           test method'una dondurur
     */

    private static Properties properties;

    static {
        String path="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
