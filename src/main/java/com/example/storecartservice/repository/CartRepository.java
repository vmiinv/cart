package com.example.storecartservice.repository;


import com.example.storecartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

    @Query(value = "SELECT * FROM cart n WHERE n.user_id=?1", nativeQuery = true)
    List<CartItem> findByProductId(Long id);

    void deleteAllByUser_id(Long id);
}
