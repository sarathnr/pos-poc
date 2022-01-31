package com.zooplus.pospoc.repository;

import com.zooplus.pospoc.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findOrderById(Long id);

}
