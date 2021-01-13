package com.javastudio.tutorial;

import com.javastudio.tutorial.api.Configuration;

public class MainConfiguration implements Configuration {
    @Override
    public String version() {
        return "1.0.0";
    }
}
