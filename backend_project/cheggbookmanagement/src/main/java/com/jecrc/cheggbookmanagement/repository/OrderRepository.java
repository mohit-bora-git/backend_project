package com.jecrc.cheggbookmanagement.repository;

import com.jecrc.cheggbookmanagement.model.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders,Integer> {


    Optional<Orders> findByOrderReference(String orderRef);
}
