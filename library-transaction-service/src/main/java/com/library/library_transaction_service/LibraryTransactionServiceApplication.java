package com.library.library_transaction_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibraryTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryTransactionServiceApplication.class, args);
	}

}
