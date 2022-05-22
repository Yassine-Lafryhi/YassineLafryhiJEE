package com.yassine.lafryhi.jee.seance10.repositories;

import com.yassine.lafryhi.jee.seance10.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
