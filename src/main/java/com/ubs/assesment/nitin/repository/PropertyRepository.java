package com.ubs.assesment.nitin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubs.assesment.nitin.entity.Property;

/**
 * The Interface UserRepository.
 */
@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer> {


}
