package com.codepresso.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	public int countByEmail(String email);

	public int countByEmailAndPassword(String email, String password);

}
