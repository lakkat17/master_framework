package com.qa.lk.framework.utils;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationFactory {

    private ConfigurationFactory() {
    }

    public static FrameworkConfig getConfig(){
        // getOrCrate uses singleton pattern. Non singleton way <ConfigFactory.create()>
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }

}
