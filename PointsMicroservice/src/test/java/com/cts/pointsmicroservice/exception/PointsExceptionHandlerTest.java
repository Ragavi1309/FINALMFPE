package com.cts.pointsmicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.ConnectException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import feign.FeignException;

@SpringBootTest
public class PointsExceptionHandlerTest {

	@InjectMocks
	PointsExceptionHandler pointsExceptionHandler;
	
	FeignException feignException;
	
	@Test
	void handleUserNotFoundExceptionTest() {
		assertEquals(pointsExceptionHandler.handleUserNotFoundException(new NullPointerException(null)).getStatusCodeValue(), 400);
	}
	
	@Test
	void handleStringIndexOutOfBoundExceptionTest() {
		assertEquals(pointsExceptionHandler.handleStringIndexOutOfBoundException(new StringIndexOutOfBoundsException(null)).getStatusCodeValue(), 400);
	}

	@Test
	void handleFeignExceptionTest() {
		assertEquals(pointsExceptionHandler.handleFeignException(feignException).getStatusCodeValue(), 400);
	}
	
	@Test
	void handleEmptyResultDataAccessExceptionTest() {
		assertEquals(pointsExceptionHandler.handleEmptyResultDataAccessException(new EmptyResultDataAccessException(1)).getStatusCodeValue(), 400);
	}
	
	
	@Test
	void handleServiceDownExceptionTest() {
		assertEquals(pointsExceptionHandler.handleServiceDownException(new ConnectException(null)).getStatusCodeValue(), 400);
	}
	
	@Test
	void handleInvalidUserExceptionTest() {
		assertEquals(pointsExceptionHandler.handleInvalidUserException(new InvalidUserException(null)).getStatusCodeValue(), 400);
	}
}
