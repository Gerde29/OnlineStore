package com.mycompany.myapp.service;

import java.util.*;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.domain.ProductCategory;
import com.mycompany.myapp.repository.ProductCategoryRepository;
import com.mycompany.myapp.repository.ProductRepository;
import com.mycompany.myapp.web.rest.ProductCategoryResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

/**
 * Service Implementation for managing Product.
 */
@Service
@Transactional
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    private ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Save a product.
     *
     * @param product the entity to save
     * @return the persisted entity
     */
    public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        boolean flag = false;
        ProductCategory productCategory = product.getProductCategory();
        ProductCategoryService productCategoryService = new ProductCategoryService(productCategoryRepository);
        ProductCategoryResource productCategoryResource = new ProductCategoryResource(productCategoryService);
        java.util.List<ProductCategory> listProductCategory = productCategoryResource.getAllProductCategories();

        for (ProductCategory var : listProductCategory) {

            if (product.getCategory() == var.getName()) {

                flag = true;
                break;

            }
        }
        if (flag == false) {
            productCategory = new ProductCategory();
            productCategory.setName(product.getCategory());
            productCategory.addProduct(product);
            productCategoryService.save(productCategory);
        }

        return productRepository.save(product);
    }

    /**
     * Get all the products.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        log.debug("Request to get all Products");
        return productRepository.findAll(pageable);
    }

    /**
     * Get one product by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Product> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findById(id);
    }

    /**
     * Delete the product by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
    }
}
