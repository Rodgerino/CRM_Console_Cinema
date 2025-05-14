package main.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }


    private static void loadProperties(){

        try(InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")){

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
