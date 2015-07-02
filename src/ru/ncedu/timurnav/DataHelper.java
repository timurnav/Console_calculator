package ru.ncedu.timurnav;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class DataHelper {

    private static Properties props;
    private static File file = new File("src\\ru\\ncedu\\timurnav\\resources\\classes.ini");
    private static long lastModified = 0;

    private static void updateProperties(){
        props = new Properties();
        try {
            props.load(new FileInputStream(file));
            lastModified = file.lastModified();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new IllegalStateException("File is not readable", e);
        }
    }

    private static Properties getPropertyFile(){
        if (file.lastModified() != lastModified) props = null;
        if (props == null) updateProperties();
        return props;
    }

    public static String getOperationsList(){
        StringBuilder sb = new StringBuilder();
        for (String s : getPropertyFile().stringPropertyNames())
            sb.append("'").append(s).append("', ");
        if (sb.length()<3)
            return "";
        return sb.substring(0, sb.length() - 2);
    }

    public static String getClassNameBySign(String sign){
        return getPropertyFile().getProperty(sign);
    }
}
