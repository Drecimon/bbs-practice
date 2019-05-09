package cn.ljlin233.util.myutil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ConfigureTest {

    @Test
    public void testConfigure() throws Exception {
        Configure config = new Configure("properties/jdbc.properties");
        assertEquals("local", config.getValue("env"));
    }

}