package com.productservicejava;

import com.productservicejava.models.Product;
import com.productservicejava.repository.ProductRepo;
import com.productservicejava.repository.ProductRepository;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.Date;
import java.util.List;

@Path("/greet")
public class HelloService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Product> doGet(){
        ProductRepo productRepo = ProductRepo.getInstance();

	   return productRepo.getProducts();

//        ProductRepository productDB = new ProductRepository();
//
//        return productDB.getProducts();

    }

}
