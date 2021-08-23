package com.spring.mfpe.offer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.mfpe.offer.repositories.EmployeeRepository;
import com.spring.mfpe.offer.repositories.OfferRepository;

@SpringBootTest
class OfferMicroserviceApplicationTests {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	OfferRepository offerRepo;
	
	@Test
	void contextLoads() {
	}

	
}
