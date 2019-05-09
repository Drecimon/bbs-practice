package cn.ljlin233.util.myutil;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import cn.ljlin233.util.exception.entity.SystemException;

public class Configure {

    private Properties config = null;

    public Configure(String filePath) {
        config = new Properties();

        try {
            ClassLoader CL = this.getClass().getClassLoader();
            //System.out.println("Class Path:  " + this.getClass());
            //System.out.println("ClassLoader Path:  " + CL);
            //System.out.println("ClassLoader Path:  " + CL.getResource(""));
            InputStream in;
            if (CL != null) {
                in = CL.getResourceAsStream(filePath);
            } else {
                in = ClassLoader.getSystemResourceAsStream(filePath);
            }

            if (in == null) {
                throw new SystemException("服务器配置文件没有找到", "服务器配置文件没有找到");
            }

            config.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            throw new SystemException("filePath", "服务器配置文件没有找到");
        } catch (Exception e) {
            throw new SystemException("服务器配置信息读取错误", e.getLocalizedMessage());
        }
    }

    public String getValue(String key) {
        if (config.containsKey(key)) {
            String value = config.getProperty(key);
            return value;
        } else {
            return "";
        }
    }

    // public static void main(String[] args) throws Exception{
    // Configure configure = new Configure("properties/jdbc.properties");
    // System.out.println(configure.getValue("mysqlUsername"));
    // }
}