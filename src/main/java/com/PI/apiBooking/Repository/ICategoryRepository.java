package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    //    @Query("SELECT c FROM Category c WHERE c.title = ?1")
    //    Optional<Category> findByTitle(String title);

}
