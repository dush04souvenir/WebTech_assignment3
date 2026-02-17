package auca.ac.rw.restfullApiAssignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        String saveProduct = productService.addNewProduct(product);

        if (saveProduct.equals("Product added successfully")) {
            return new ResponseEntity<>(saveProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(saveProduct, HttpStatus.CONFLICT);
        }
    }

    // let us search by id
    @GetMapping(value = "/searchById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchProductById(@RequestBody Product product) {
        Product foundProduct = productService.searchProductById(product.getId());

        if (foundProduct != null) {
            return new ResponseEntity<>(foundProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping(value = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        String updateProduct = productService.updateProduct(product);
        if (updateProduct.equals("Product updated successfully")) {
            return new ResponseEntity<>(updateProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updateProduct, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deleteProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        String deleteProduct = productService.deleteProduct(product.getId());
        if (deleteProduct.equals("Product deleted successfully")) {
            return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deleteProduct, HttpStatus.NOT_FOUND);
        }
    }
}
