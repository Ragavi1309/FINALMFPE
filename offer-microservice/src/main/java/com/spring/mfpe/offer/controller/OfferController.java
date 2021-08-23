package com.spring.mfpe.offer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mfpe.offer.entities.Offer;
import com.spring.mfpe.offer.exceptions.EmployeeNotFoundException;
import com.spring.mfpe.offer.exceptions.ImproperDateException;
import com.spring.mfpe.offer.exceptions.InvalidTokenException;
import com.spring.mfpe.offer.exceptions.MicroserviceException;
import com.spring.mfpe.offer.exceptions.OfferAlreadyEngagedException;
import com.spring.mfpe.offer.exceptions.OfferNotFoundException;
import com.spring.mfpe.offer.model.SuccessResponse;
import com.spring.mfpe.offer.services.OfferService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/offer")
public class OfferController {

	@Autowired
	OfferService offerService;

	/**
	 * 
	 * @param offerId
	 * @return
	 * @throws OfferNotFoundException returns offer details for a specific offer id
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOfferDetails/{offerId}")
	public Offer getOfferDetails(@RequestHeader("Authorization") String token, @PathVariable("offerId") int offerId)
			throws OfferNotFoundException, InvalidTokenException, MicroserviceException {

		log.debug("Inside getOfferDetails method of offer microservice.");
		Offer offer = offerService.getOfferDetails(token, offerId);
		return offer;
	}

	/**
	 * returns offer filtered by category
	 * 
	 * @param category
	 * @return
	 * @throws OfferNotFoundException
	 * @throws MicroserviceException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOfferByCategory/{category}")
	public List<Offer> getOfferByCategory(@RequestHeader("Authorization") String token,
			@PathVariable("category") String category)
			throws OfferNotFoundException, MicroserviceException, InvalidTokenException {
		log.debug("Inside getOfferByCategory method of offer microservice.");
		List<Offer> offers = offerService.getOfferByCategory(token, category);
		return offers;
	}

	/**
	 * returns top 3 offers filtered by likes
	 * 
	 * @return
	 * @throws OfferNotFoundException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOfferByTopLikes")
	public List<Offer> getOfferByTopLikes(@RequestHeader("Authorization") String token)
			throws OfferNotFoundException, InvalidTokenException, MicroserviceException {
		log.debug("Inside getOFferByTopLikes method of offer microservice.");
		List<Offer> offers = offerService.getOfferByTopLikes(token);
		return offers;
	}

	/**
	 * return offers filtered by posted date
	 * 
	 * @param postedDate
	 * @return
	 * @throws OfferNotFoundException
	 * @throws ImproperDateException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getOfferByPostedDate/{date}")
	public List<Offer> getOfferByPostedDate(@RequestHeader("Authorization") String token,
			@PathVariable("date") String postedDate)
			throws OfferNotFoundException, ImproperDateException, InvalidTokenException, MicroserviceException {
		log.debug("Inside getOfferByPostedDate method of offer microservice.");
		List<Offer> offers = offerService.getOfferByPostedDate(token, postedDate);
		return offers;
	}

	/**
	 * engage a buyer with the offer
	 * 
	 * @param offerId
	 * @param employeeId
	 * @return
	 * @throws OfferNotFoundException
	 * @throws OfferAlreadyEngagedException
	 * @throws EmployeeNotFoundException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/engageOffer")
	public SuccessResponse engageOffer(@RequestHeader("Authorization") String token,
			@RequestParam(name = "offerId") int offerId, @RequestParam(name = "employeeId") int employeeId)
			throws OfferNotFoundException, OfferAlreadyEngagedException, EmployeeNotFoundException,
			MicroserviceException, InvalidTokenException {
		log.debug("Inside engage offer method of offer microservice.");
		SuccessResponse status = offerService.engageOffer(token, offerId, employeeId);
		return status;
	}

	/**
	 * update the existing offer
	 * 
	 * @param offer
	 * @return
	 * @throws OfferNotFoundException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/editOffer")
	public SuccessResponse editOffer(@RequestHeader("Authorization") String token, @RequestBody Offer offer)
			throws OfferNotFoundException, InvalidTokenException, MicroserviceException {
		log.debug("Inside editOffer method of offer microservice.");
		SuccessResponse status = offerService.editOffer(token, offer);
		return status;
	}

	/**
	 * add a new offer
	 * 
	 * @param offer
	 * @return
	 * @throws EmployeeNotFoundException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addOffer")
	public SuccessResponse addOffer(@RequestHeader("Authorization") String token, @RequestBody Offer offer)
			throws EmployeeNotFoundException, InvalidTokenException, MicroserviceException {
		log.debug("Inside addOffer method of offer microservice.");
		SuccessResponse status = offerService.addOffer(token, offer);
		return status;
	}

	/**
	 * returns the list of offers for a particular employee id (helper function for
	 * employee microService)
	 * 
	 * @param emp_id
	 * @return
	 * @throws OfferNotFoundException
	 * @throws MicroserviceException
	 * @throws InvalidTokenException
	 */
	@GetMapping("/getOffers/{emp_id}")
	public List<Offer> getOffersById(@RequestHeader("Authorization") String token, @PathVariable("emp_id") int emp_id)
			throws OfferNotFoundException, InvalidTokenException, MicroserviceException {
		log.debug("Inside getOffersById method of offer microservice.");
		List<Offer> offers = offerService.getOffersById(token, emp_id);
		return offers;
	}

	/**
	 * retrieve points gained by an employee
	 * 
	 * @param token
	 * @param emp_id
	 * @return
	 * @throws OfferNotFoundException
	 * @throws InvalidTokenException
	 * @throws MicroserviceException
	 */
	@GetMapping("/getPoints/{emp_id}")
	public int getPointsById(@RequestHeader("Authorization") String token, @PathVariable("emp_id") int emp_id)
			throws OfferNotFoundException, InvalidTokenException, MicroserviceException {
		log.debug("Inside getPointsById method of offer microservice.");
		int points = offerService.getPointsById(token, emp_id);
		return points;
	}

	/**
	 * update the likes of the offer
	 * 
	 * @param token
	 * @param id
	 * @return
	 * @throws OfferNotFoundException
	 * @throws MicroserviceException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateLikes/{offer_id}")
	public SuccessResponse updateLikes(@RequestHeader("Authorization") String token, @PathVariable("offer_id") int id)
			throws MicroserviceException, OfferNotFoundException {
		log.debug("Inside update likes method of offer microservice.");
		return offerService.updateLikes(token, id);
	}
	
	/**
	 * return all the offers
	 * 
	 * @param token
	 * @return
	 * @throws MicroserviceException
	 * @throws OfferNotFoundException
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllOffers")
	public List<Offer> getAllOffers(@RequestHeader("Authorization") String token)
			throws MicroserviceException, OfferNotFoundException {
		log.debug("Inside getAllOffers method of offer microservice");
		return offerService.getAllOffers(token);
	}
}
