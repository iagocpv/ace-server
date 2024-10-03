package com.fatec.ace.exception;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ExceptionResource {
	
	public ExceptionResource(Integer status, String message) {
		this.status = status;
		this.message = message;
		this.timestamp = Calendar.getInstance();
	}

    private Integer status;
    
    private String message;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Calendar timestamp;
}
