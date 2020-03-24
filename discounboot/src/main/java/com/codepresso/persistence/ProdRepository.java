package com.codepresso.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Prod;

@Repository
public interface ProdRepository extends CrudRepository<Prod, Long> {

	Prod findByNo(Long no);

}
