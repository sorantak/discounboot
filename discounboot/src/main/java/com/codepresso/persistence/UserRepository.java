package com.codepresso.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public int countByEmail(String email);

	public int countByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

	public Optional<User> findById(Long Id);

}
