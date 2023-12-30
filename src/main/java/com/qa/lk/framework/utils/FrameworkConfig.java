package com.qa.lk.framework.utils;

import com.qa.lk.framework.enums.BrowserType;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

@Config.Sources(
        {"system:properties",
                "system:env",
                "file:${user.dir}/src/test/resources/config.properties"}
)
public interface FrameworkConfig extends Config {

    class StringToBrowserType implements Converter<BrowserType> {

        @Override
        public BrowserType convert(Method method, String browserName) {
            Map<String, BrowserType> map = Map.of("chrome", BrowserType.CHROME, "firefox", BrowserType.FIREFOX);
            return map.getOrDefault(browserName, BrowserType.CHROME);
        }
    }

    @DefaultValue("chrome")
    @ConverterClass(StringToBrowserType.class)
    BrowserType browser();
}
