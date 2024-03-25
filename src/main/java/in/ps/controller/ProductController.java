package in.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ps.entity.Product;
import in.ps.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public Product saveProduct(@RequestBody Product product){
		
		return productService.saveProduct(product);
	}
	
	@GetMapping("/")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
		
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Integer id){
		return productService.getProductById(id);
		
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id){
		return productService.deleteProduct(id);
		
	}
	
	@PostMapping("/editProduct")
	public Product editProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	
	@PostMapping("/editProduct/{id}")
	public Product editProduct(@RequestBody Product product, @PathVariable Integer id) {
		return productService.editProduct(product, id);
	}
}
