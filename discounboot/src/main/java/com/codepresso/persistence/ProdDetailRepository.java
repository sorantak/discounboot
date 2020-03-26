package com.codepresso.persistence;

import org.springframework.data.repository.CrudRepository;

import com.codepresso.domain.ProdDetail;

public interface ProdDetailRepository extends CrudRepository<ProdDetail, Long> {

}
