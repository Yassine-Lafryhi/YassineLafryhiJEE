package com.yassine.lafryhi.jee.seance10.repositories;

import com.yassine.lafryhi.jee.seance10.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
