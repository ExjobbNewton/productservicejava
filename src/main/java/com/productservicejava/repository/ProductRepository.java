/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productservicejava.repository;

import com.productservicejava.models.Product;
import com.productservicejava.models.ProductsEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author louiseahokas
 */
public class ProductRepository {

    public List<ProductsEntity> getProducts() {
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("Will now open session with Hibernate");
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaQuery<ProductsEntity> criteriaQuery = session.getCriteriaBuilder().createQuery(ProductsEntity.class);
        criteriaQuery.from(ProductsEntity.class);

        List<ProductsEntity> products = session.createQuery(criteriaQuery).getResultList();
        session.close();

        HibernateUtil.shutdown();

        return products;
    }

//    public Product addProduct(Product product) {
//        Session session= HibernateUtil.getSession();
//        session.beginTransaction();
//        session.save(product);
//        session.getTransaction().commit();
//        session.close();
//        return product;
//    }
//
//    public Product getProduct(int id) {
//        Session session= HibernateUtil.getSession();
//        Product product = (Product)session.get(Product.class, id);
//        session.close();
//        return product;
//    }
//    public Product removeProduct(int id) {
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//        Product t = new Product();
//        t.setId(id);
//        session.delete(t);
//        session.getTransaction().commit();
//        session.close();
//        return t;
//    }
//
//    public Product updateProduct(int id, Product product) {
//        Session session = HibernateUtil.getSession();
//        session.beginTransaction();
//
//        Product newProduct = (Product)session.get(Product.class, id);
//
//        newProduct.setProductImageUrl(product.getProductImageUrl());
//        newProduct.setProductName(product.getProductName());
//
//        session.update(newProduct);
//
//        session.getTransaction().commit();
//        session.close();
//        return product;
//    }

}
