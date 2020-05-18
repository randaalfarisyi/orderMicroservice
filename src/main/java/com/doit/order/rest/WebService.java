package com.doit.order.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.doit.order.wrapper.AlternativeMobilePhoneWrapper;
import com.doit.order.wrapper.BorrowerWrapper;
import com.doit.order.wrapper.EmergencyContactSegmentsWrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class WebService {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	// Consumer Borrower UserMicroservice
	public BorrowerDetail getBorrowerByUuid(String uuid) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuid;
		String borrower = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(borrower);
		JsonNode result = node.get("result");
		
		BorrowerDetail borrowerResult = mapper.treeToValue(result, BorrowerDetail.class);
		return borrowerResult;
	}
	
	// Consumer UserSegments UserMicroservice

	public UserSegmentsDetail getUserSegmentsByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/user-detail";
		String userSegments = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(userSegments);
		JsonNode result = node.get("result");
		
		UserSegmentsDetail userSegmentsResult = mapper.treeToValue(result, UserSegmentsDetail.class);
		return userSegmentsResult;
	}
	
	// Consumer HomePhone UserMicroservice
	public PhoneDetail getHomePhoneByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/user-detail/home-phone";
		String homePhone = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(homePhone);
		JsonNode result = node.get("result");
		
		PhoneDetail homePhoneResult = mapper.treeToValue(result, PhoneDetail.class);
		return homePhoneResult;

	}
	
	// Consumer AlternativeMobilePhone UserMicroservice
	public List<AlternativeMobilePhoneDetail> getAlternativeMobilePhoneByUuidBorrower(String uuidBorrower) {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/user-detail/alternative-mobile-phone";
		List<AlternativeMobilePhoneDetail> returnList = restTemplate.getForEntity(path, AlternativeMobilePhoneWrapper.class).getBody().getResult();
		return returnList;
	}
	
	// Consumer HomeAddrRegion UserMicroservice

	public AddrRegionDetail getHomeAddrRegionByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/user-detail/home-address-region";
		String homeAddrRegion = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(homeAddrRegion);
		JsonNode result = node.get("result");
		
		AddrRegionDetail homeAddrRegionResult = mapper.treeToValue(result, AddrRegionDetail.class);
		return homeAddrRegionResult;
	}
	
	// Consumer IncomeSegmentsRegion UserMicroservice
	public IncomeSegmentsDetail getIncomeSegmentsByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/income-detail";
		String incomeSegments = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(incomeSegments);
		JsonNode result = node.get("result");
		
		IncomeSegmentsDetail incomeSegmentsResult = mapper.treeToValue(result, IncomeSegmentsDetail.class);
		return incomeSegmentsResult;
	}
	
	// Consumer WorkAddrRegion UserMicroservice
	public AddrRegionDetail getWorkAddrRegionByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/income-detail/work-address-region";
		String workAddrRegion = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(workAddrRegion);
		JsonNode result = node.get("result");
		
		AddrRegionDetail workAddrRegionResult = mapper.treeToValue(result, AddrRegionDetail.class);
		return workAddrRegionResult;
	}
	
	// Consumer WorkPhone UserMicroservice
	public PhoneDetail getWorkPhoneByUuidBorrower(String uuidBorrower) throws IOException {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/income-detail/work-phone";
		String workPhone = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(workPhone);
		JsonNode result = node.get("result");
		
		PhoneDetail workPhoneResult = mapper.treeToValue(result, PhoneDetail.class);
		return workPhoneResult;

	}
	
	// Consumer WorkPhone UserMicroservice
	public List<EmergencyContactSegmentsDetail> getEmergencyContactSegmentsByUuidBorrower(String uuidBorrower) {
		String path = Setting.userMicroserviceUrl+"/borrower/"+uuidBorrower+"/emergency-contact";
		List<EmergencyContactSegmentsDetail> returnList = restTemplate.getForEntity(path, EmergencyContactSegmentsWrapper.class).getBody().getResult();
		return returnList;
	}
	
	// Consumer MasterData UserMicroservice
	public MasterDataDetail getMasterData(String groupData, String code) throws IOException {
		String path = Setting.userMicroserviceUrl+"/master-data/"+groupData+"/"+code;
		String masterData = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(masterData);
		JsonNode result = node.get("result");
		
		MasterDataDetail masterDataResult = mapper.treeToValue(result, MasterDataDetail.class);
		return masterDataResult;
	}
	
	// Consumer MasterData With Parent UserMicroservice
	public MasterDataDetail getMasterDataWithParent(String groupData, String code, String parentUuid) throws IOException {
		String path = Setting.userMicroserviceUrl+"/master-data/"+groupData+"/"+code+"/"+parentUuid;
		String masterData = restTemplate.getForObject(path, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(masterData);
		JsonNode result = node.get("result");
		
		MasterDataDetail masterDataResult = mapper.treeToValue(result, MasterDataDetail.class);
		return masterDataResult;
	}
	
	// Consumer BorrowerList UserMicroservice
	public List<BorrowerDetail> getAllBorrower() {
		String path = Setting.userMicroserviceUrl+"/borrower/all";
		List<BorrowerDetail> returnList = restTemplate.getForEntity(path, BorrowerWrapper.class).getBody().getResult();
		return returnList;
	}
}
