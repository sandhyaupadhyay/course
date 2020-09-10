package com.pixels.officeaddresssearch.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.pixels.officeaddresssearch.model.OfficeAddress;

import reactor.core.publisher.Flux;


@Repository
public interface AddressRepository extends ReactiveMongoRepository<OfficeAddress, String> {

	@Query("{ 'officename':{$regex:?0,$options:'i'}}")
	public Flux<OfficeAddress> findByOfficeName(String officename);
	
	@Query("{ 'Districtname':{$regex:?0,$options:'i'}}")
	public Flux<OfficeAddress> findByDistrictName(String districtname);
}
