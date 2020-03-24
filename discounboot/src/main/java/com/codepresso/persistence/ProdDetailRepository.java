package com.codepresso.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codepresso.domain.ProdDetail;

public interface ProdDetailRepository extends CrudRepository<ProdDetail, Long> {

	List<ProdDetail> findIdAndContentAndImageUrlAndCreatedAtAndProdNoByProdNo(Long prodNo);

}
