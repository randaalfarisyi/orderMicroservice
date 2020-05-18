package com.doit.order.restcontroller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.SchedulerModel;
import com.doit.order.repository.ProductTypeDB;
import com.doit.order.response.ProductTypeDetailResponse;
import com.doit.order.service.OrderService;
import com.doit.order.service.ProductTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;
    
    
    @GetMapping(value ="/products")
    public List<ProductTypeModel> getAllProducts() {
    	List<ProductTypeModel> products = new ArrayList<>();
    	productTypeService.getAllProductType().forEach(products::add);
        return products;
    }
    
    @GetMapping(value = "/product/{uuid}")
    public ProductTypeDetailResponse productView(@PathVariable("uuid") String uuid) {
    	ProductTypeModel productType = productTypeService.getProductTypeDetailByUuid(uuid).get();
    	List<SchedulerModel> schedulerList = productType.getSchedulerList();
    	ProductTypeDetailResponse productTypeDetailResponse = new ProductTypeDetailResponse();
    	productTypeDetailResponse.setUuid(productType.getUuid());
    	productTypeDetailResponse.setProductType(productType);
    	productTypeDetailResponse.setScheduler(schedulerList);
        return productTypeDetailResponse;
    }
    	
    @PutMapping(value = "/product/{uuid}/update")
    public ResponseEntity<ProductTypeModel> updateProduct(@PathVariable("uuid") String uuid, @RequestBody ProductTypeModel productUpdated) {
    	System.out.println("Eh Keluar gak?");
    	System.out.println(productUpdated);
    	ProductTypeModel updatedProduct = productTypeService.changeProduct(productUpdated);
    	System.out.println("Eh Keluar gak?");
    	System.out.println(productUpdated.getInterestRate());
        return new ResponseEntity<ProductTypeModel>(updatedProduct, HttpStatus.OK);
    }
    
    @PostMapping(value = "/updateProd")
    public ProductTypeModel putProduct(@RequestBody ProductTypeModel productType) {
    	ProductTypeModel updatedProduct = productTypeService.changeProduct(productType);
    	return updatedProduct;
    }
    
    @PostMapping(value = "/product/addproduct")
    public ResponseEntity<Void> addProduct (@RequestBody ProductTypeModel product) {
    	ProductTypeModel newProduct = productTypeService.addProductType(product);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(newProduct.getUuid()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @PostMapping(value = "/addProd")
    public ProductTypeModel postProduct(@RequestBody ProductTypeModel productType) {
    	ProductTypeModel newProductType = productTypeService.addProductType(productType);
    	return newProductType;
    }
   /* @PostMapping("borrower/create")
	public ResponseEntity<Void> createBorrower(@RequestBody BorrowerModel borrower) {
		BorrowerModel createdBorrower = borrowerService.addBorrower(borrower);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(createdBorrower.getUuid())
        .toUri();

<<<<<<< HEAD
    	return ResponseEntity.created(uri).build();

	@PutMapping("/borrower/{uuid}")
	public ResponseEntity<BorrowerModel> updateBorrowerSuccess(@PathVariable String uuid, @RequestBody BorrowerModel borrowerupdated){
		BorrowerModel updatedBorrower = borrowerService.changeBorrower(borrowerupdated);
		return new ResponseEntity<BorrowerModel>(borrowerupdated, HttpStatus.OK);
	}
	@PutMapping("/borrower/{uuid}")
	public ResponseEntity<BorrowerModel> updateBorrowerSuccess(@PathVariable String uuid, @RequestBody BorrowerModel borrowerupdated){
		BorrowerModel updatedBorrower = borrowerService.changeBorrower(borrowerupdated);
		return new ResponseEntity<BorrowerModel>(borrowerupdated, HttpStatus.OK);
	}
	}*/

//public class ProductTypeController {
  //  @Autowired
    //ProductTypeService productTypeService;
    
    //@GetMapping(value ="/products")
    //public List<ProductTypeModel> getAllProducts() {
    	//List<ProductTypeModel> products = new ArrayList<>();
    	//productTypeService.getAllProductType().forEach(products::add);
        //return products;
   // }
}
