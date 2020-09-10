package com.pixels.officeaddresssearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pixels.officeaddresssearch.model.OfficeAddress;
import com.pixels.officeaddresssearch.repository.AddressRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/getOffice")
public class OfficeAddressController {

	
	@Autowired
	private AddressRepository repo;

	@GetMapping("/getOfficeDetail")
	public Flux<OfficeAddress> getAddress()
	{
		return repo.findAll().limitRequest(20);
	}
	
	@GetMapping("/getOfficebyofficename/{officename}")
	public Flux<OfficeAddress> getOfficeadddressbyOfficeName(@PathVariable String officename)
	{
		String officeaddressname="^"+officename;
		Flux<OfficeAddress> ls=repo.findByOfficeName(officeaddressname);
		return ls;
	}
	
	@GetMapping("/getOfficebydistrictname/{districtname}")
	public Flux<OfficeAddress> getOfficeadddressbyDistrict(@PathVariable String districtname)
	{
		String distname="^"+districtname;
		Flux<OfficeAddress> ls=repo.findByDistrictName(distname);
		
		return ls;
	}
}
