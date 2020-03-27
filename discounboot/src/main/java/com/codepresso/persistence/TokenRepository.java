package com.codepresso.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {

	public Token findByToken(String token);

//	public Token findByUserEmail(String userEmail);

	public int countByUserId(Long userId);

	public Token findByUserId(Long userId);

}
