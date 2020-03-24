package com.codepresso.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, String> {

	public int countByUserEmail(String email);

	public Token findByToken(String tokenToString);

	public Token findByUserEmail(String userEmail);

}
