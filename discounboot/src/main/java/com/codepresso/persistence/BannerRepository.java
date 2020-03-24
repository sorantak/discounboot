package com.codepresso.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.Banner;

@Repository
public interface BannerRepository extends CrudRepository<Banner, Long> {

	List<Banner> findAll(Pageable paging);

}
