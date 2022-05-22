package com.yassine.lafryhi.jee.seance10.services;

import com.yassine.lafryhi.jee.seance10.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> listProducts();
    ProductDTO getProduct(String id);
    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(String id);
}
