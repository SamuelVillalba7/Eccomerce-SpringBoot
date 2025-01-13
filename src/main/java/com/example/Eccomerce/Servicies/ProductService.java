package com.example.Eccomerce.Servicies;

import aj.org.objectweb.asm.Opcodes;
import com.example.Eccomerce.Dto.ProductDto;
import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Entities.OrderDetail;
import com.example.Eccomerce.Entities.Product;
import com.example.Eccomerce.Exceptions.ResourceNotFoundException;
import com.example.Eccomerce.Repositories.CategoryRepository;
import com.example.Eccomerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public ProductRepository repository;
    public CategoryRepository repositoryCategory;

    @Autowired
    public ProductService(ProductRepository repository, CategoryRepository repositoryCategory) {
        this.repository = repository;
        this.repositoryCategory = repositoryCategory;
    }

    public List<ProductDto> findAll(){

        List<ProductDto>listDto= new ArrayList<>();
        List<Product>list = repository.findAll();

        for(Product product:list){
            listDto.add(convertToDto(product));
        }
        return listDto;
    }

    public List<ProductDto> findByCategory(Integer id){

        List<ProductDto>listDto= new ArrayList<>();
        List<Product>list = repository.findAll();

        for(Product product:list){
            if(product.getCategory().getId()==id){
                listDto.add(convertToDto(product));
            }
        }
        return listDto;
    }



    public ProductDto update(ProductDto productDto) throws ResourceNotFoundException {

        Product product = repository.findById(productDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("no se encontro producto con id : "+ productDto.getId()));
        Category category= repositoryCategory.findById(productDto.getIdCategory())
                .orElseThrow(()->new ResourceNotFoundException("no se encontro categoria con id : " + productDto.getIdCategory()));

        product.setState(productDto.getState());
        product.setCategory(category);
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setUrlImage(productDto.getUrlImage());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        repository.save(product);
        return convertToDto(product);



    }

    public ProductDto save(ProductDto productDto){

        Product product = new Product();

        Optional<Category> categoryOpc =repositoryCategory.findById(productDto.getIdCategory()) ;

        if(categoryOpc.isPresent()){
            Category category= categoryOpc.get();
            product.setCategory(category);
            product.setName(productDto.getName());
            product.setUrlImage(productDto.getUrlImage());
            product.setStock(productDto.getStock());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setState(productDto.getState());

            repository.save(product);
            return convertToDto(product);
        }
        return productDto;
    }

    public Optional<ProductDto> findById(Integer id){
        Optional<ProductDto> productDtoOpc= null;
        Optional<Product>productOpc=repository.findById(id);
        if(productOpc.isPresent()){
            Product product= productOpc.get();
            ProductDto productDto= new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setState(product.getState());
            productDto.setPrice(product.getPrice());
            productDto.setStock(product.getStock());
            productDto.setDescription(product.getDescription());
            productDto.setUrlImage(product.getUrlImage());
            productDto.setIdCategory(product.getCategory().getId());
            productDtoOpc = Optional.of(productDto) ;
        }
        return productDtoOpc;
    }

    public void deleteById(Integer id){
         repository.deleteById(id);
    }


    public ProductDto lowLogic(Integer id) throws ResourceNotFoundException {

        ProductDto productDto= findById(id)
            .orElseThrow(()-> new RuntimeException("Product not found"));
        productDto.setState(false);
        return update(productDto);


    }


    public ProductDto highLogic(Integer id) throws ResourceNotFoundException {

        ProductDto productDto= findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
        productDto.setState(true);
        return update(productDto);


    }
    public ProductDto convertToDto(Product product){

        ProductDto productDto= new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setState(product.getState());
        productDto.setIdCategory(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setDescription(product.getDescription());
        productDto.setUrlImage(product.getUrlImage());
        return productDto;
    }

    public void discountStock(List<OrderDetail> list) throws ResourceNotFoundException {

        for(OrderDetail detail:list){
            Integer stock = detail.getProduct().getStock();
            detail.getProduct().setStock(stock - (detail.getQuantity()));
            update(convertToDto(detail.getProduct()));
        }


    }
}
