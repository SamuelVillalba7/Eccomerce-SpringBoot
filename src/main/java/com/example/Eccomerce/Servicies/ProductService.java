package com.example.Eccomerce.Servicies;

import aj.org.objectweb.asm.Opcodes;
import com.example.Eccomerce.Dto.ProductDto;
import com.example.Eccomerce.Entities.Category;
import com.example.Eccomerce.Entities.Product;
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
            listDto.add(new ProductDto(product.getId(), product.getName(), product.getStock() ,product.getPrice(), product.getUrlImage() ,product.getDescription(), product.getCategory() != null ? product.getCategory().getId() : null));
        }
        return listDto;
    }

    public List<ProductDto> findByCategory(Integer id){

        List<ProductDto>listDto= new ArrayList<>();
        List<Product>list = repository.findAll();

        for(Product product:list){

            if(product.getCategory().getId()==id){
                listDto.add(new ProductDto(product.getId(), product.getName(), product.getStock(),product.getPrice(), product.getUrlImage() ,product.getDescription(), product.getCategory() != null ? product.getCategory().getId() : null));
            }

        }
        return listDto;
    }



    public ProductDto update(ProductDto productDto){

        Optional<Product>productOpc= repository.findById(productDto.getId());
        Optional<Category>categoryOpc=repositoryCategory.findById(productDto.getId_category());
        if(productOpc.isPresent() && categoryOpc.isPresent()){
            Product product = productOpc.get();
            Category category = categoryOpc.get();

            product.setCategory(category);
            product.setName(productDto.getName());
            product.setId(productDto.getId());
            product.setUrlImage(productDto.getUrlImage());
            product.setStock(productDto.getStock());
            product.setPrice(productDto.getPrice());
            product.setDescription(product.getDescription());

            repository.save(product);

            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setId_category(product.getCategory().getId());
            productDto.setPrice(product.getPrice());
            productDto.setStock(product.getStock());
            productDto.setDescription(product.getDescription());
            productDto.setUrlImage(product.getUrlImage());
        }

        return productDto;
    }

    public ProductDto save(ProductDto productDto){

        Product product = new Product();

        Optional<Category> categoryOpc =repositoryCategory.findById(productDto.getId_category()) ;

        if(categoryOpc.isPresent()){
            Category category= categoryOpc.get();
            product.setCategory(category);
            product.setName(productDto.getName());
            product.setUrlImage(productDto.getUrlImage());
            product.setStock(productDto.getStock());
            product.setPrice(productDto.getPrice());
            product.setDescription(product.getDescription());

            repository.save(product);

            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setId_category(product.getCategory().getId());
            productDto.setPrice(product.getPrice());
            productDto.setStock(product.getStock());
            productDto.setDescription(product.getDescription());
            productDto.setUrlImage(product.getUrlImage());

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
            productDto.setPrice(product.getPrice());
            productDto.setStock(product.getStock());
            productDto.setDescription(product.getDescription());
            productDto.setUrlImage(product.getUrlImage());
            productDto.setId_category(product.getCategory().getId());
            productDtoOpc = Optional.of(productDto) ;
        }
        return productDtoOpc;
    }

    public void deleteById(Integer id){
         repository.deleteById(id);
    }


}
