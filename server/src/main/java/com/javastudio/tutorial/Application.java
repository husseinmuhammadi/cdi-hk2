package com.javastudio.tutorial;

import com.javastudio.tutorial.api.Configuration;
import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.service.ProductServiceImpl;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Application {
    @Inject
    ProductService productService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application started!");
        new Application().start();
    }

    public void start() {
        LOGGER.info("Binding all dependencies!");
        bind();
        productService.test();
        productService.finalAll();
    }

    private void bind() {
        ServiceLocator locator = ServiceLocatorUtilities.bind(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ProductServiceImpl.class).to(ProductService.class).in(Singleton.class);
                bind(MainConfiguration.class).to(Configuration.class).in(Singleton.class);
            }
        });
        locator.inject(this);
    }
}
