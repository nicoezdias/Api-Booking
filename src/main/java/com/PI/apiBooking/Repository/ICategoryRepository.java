package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.id = ?1")
    Integer countByCategory(Long categoryId);
}
