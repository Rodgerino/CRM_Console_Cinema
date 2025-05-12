package main.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    static {
        loadProperties();
    }

    private static final Properties PROPERTIES = new Properties();

    private static void loadProperties(){

        try(InputStream is = PropertiesUtil.class.getResourceAsStream("application.properties")){

        PROPERTIES.load(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    public PropertiesUtil(){
    }

}
