package com.ubs.assesment.nitin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubs.assesment.nitin.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(@Param("username") String username);

}
