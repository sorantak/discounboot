package com.codepresso.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Prod;

@Repository
public interface ProdRepository extends CrudRepository<Prod, Long> {

	List<Prod> findAll(Pageable paging);

	Prod findOneById(Long id);

}
