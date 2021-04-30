package com.johnebri.customerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class UtilService {
	
	BaseResponseWrapper baseResponseWrapper = new BaseResponseWrapper();
	
	public ResponseEntity<?> getResponse(BindingResult bindingResult) {
		List<FieldError> errors = bindingResult.getFieldErrors();
		List<String> errorMessage = new ArrayList<>();
		for(FieldError e: errors) {
			errorMessage.add(e.getDefaultMessage());
		}
		baseResponseWrapper.setMessage("Validation Errors Found");
		baseResponseWrapper.setData(errorMessage);
		return new ResponseEntity<>(baseResponseWrapper, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<?> getResponse(String message, Object data, HttpStatus statusCode) {
		baseResponseWrapper.setMessage(message);
		baseResponseWrapper.setData(data);
		return new ResponseEntity<>(baseResponseWrapper, statusCode);
	}

	public String generateAccountNo() {
		long accNo = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return Long.toString(accNo) + "-01";
	}

}
