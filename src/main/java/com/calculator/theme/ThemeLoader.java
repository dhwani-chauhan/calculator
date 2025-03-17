package main.java.com.calculator.theme;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import main.java.com.calculator.theme.properties.Theme;
import main.java.com.calculator.theme.properties.ThemeList;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class ThemeLoader {
    private ThemeLoader(){
        throw new AssertionError("Constructor not allowed");
    }

    public static Map<String, Theme> loadThemes(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try{
            String str = "src/main/java/com/calculator/resources/application.yaml";
            //System.out.println(str);
            ThemeList themeList = mapper.readValue(new File(str),ThemeList.class);
            System.out.println(" 1 ");
            return themeList.getThemesAsMap();
        } catch (IOException e) {
            System.out.println("Error");
            return Collections.emptyMap();
        }
    }
}
