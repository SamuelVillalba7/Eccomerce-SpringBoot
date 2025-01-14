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

    public List<ProductDto> findByCategory(Integer id) throws ResourceNotFoundException {

        List<ProductDto>listDto= new ArrayList<>();
        List<Product>list = repository.findAll();
        repositoryCategory.findById(id).orElseThrow(()->new ResourceNotFoundException("no se encontro categoria con id : "+id));

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

        product = convertToEntity(product,productDto,category);
        repository.save(product);
        return convertToDto(product);



    }

    public ProductDto save(ProductDto productDto) throws ResourceNotFoundException {

        Product product = new Product();

        Category category = repositoryCategory.findById(productDto.getIdCategory()).
                orElseThrow(()->new ResourceNotFoundException("categoria no valida : "+ productDto.getIdCategory()));

        product = convertToEntity(product,productDto,category);

        repository.save(product);

        return convertToDto(product);


    }

    public ProductDto findById(Integer id) throws ResourceNotFoundException {

        Product product=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("no se encontro el producto con id : " + id));
        return convertToDto(product);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {

        repository.findById(id).
                orElseThrow(()-> new  ResourceNotFoundException("no se encontro producto con id : " + id));

        repository.deleteById(id);
    }


    public ProductDto toggleState(Boolean state, Integer id) throws ResourceNotFoundException {
        Product product= repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        product.setState(state);
       return update(convertToDto(product));
    }


    public ProductDto lowLogic(Integer id) throws ResourceNotFoundException {
        return toggleState(false,id);
    }


    public ProductDto highLogic(Integer id) throws ResourceNotFoundException {
        return toggleState(true,id);
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


    public Product convertToEntity(Product product,ProductDto productDto,Category category){
        product.setState(productDto.getState());
        product.setCategory(category);
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setUrlImage(productDto.getUrlImage());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return product;
    }

    public void discountStock(List<OrderDetail> list) throws ResourceNotFoundException {

        for(OrderDetail detail:list){
            Integer stock = detail.getProduct().getStock();
            detail.getProduct().setStock(stock - (detail.getQuantity()));
            update(convertToDto(detail.getProduct()));
        }


    }
}
