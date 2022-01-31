package com.zooplus.pospoc.repository;

import com.zooplus.pospoc.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer save(Customer customer);
}
