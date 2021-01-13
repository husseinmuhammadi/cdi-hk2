package com.javastudio.tutorial.service;

import com.javastudio.tutorial.api.Configuration;
import com.javastudio.tutorial.api.ProductService;
import com.javastudio.tutorial.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Inject
    Configuration configuration;

    @Override
    public void test() {
        LOGGER.info(configuration.version());
    }

    @Override
    public List<Product> finalAll() {
        return List.of(
                Product.builder().id(1).name("Nail").build(),
                Product.builder().id(2).name("Hammer").build(),
                Product.builder().id(3).name("Axe").build()
        );
    }
}
