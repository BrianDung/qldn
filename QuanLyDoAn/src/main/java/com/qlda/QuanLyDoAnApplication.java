package com.qlda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.qlda.Entity.TaiKhoan;

@SpringBootApplication
@ComponentScan({ "com.qlda.*" })
public class QuanLyDoAnApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyDoAnApplication.class, args);
	}

}
