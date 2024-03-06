package com.bookProject;

import org.hibernate.cfg.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


import javax.crypto.KeyGenerator;
import java.util.concurrent.ThreadPoolExecutor;



@SpringBootApplication
public class BookProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookProjectApplication.class, args);



	}

}
