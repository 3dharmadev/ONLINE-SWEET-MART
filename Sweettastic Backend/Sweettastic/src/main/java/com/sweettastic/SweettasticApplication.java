package com.sweettastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sweettastic.admin", "com.sweettastic.cart", "com.sweettastic.category", "com.sweettastic.customer", "com.sweettastic.orderbill", "com.sweettastic.product", "com.sweettastic.sweetorder", "com.sweettastic.user"})
@EntityScan(basePackages = {"com.sweettastic.admin", "com.sweettastic.cart", "com.sweettastic.category", "com.sweettastic.customer", "com.sweettastic.orderbill", "com.sweettastic.product", "com.sweettastic.sweetorder", "com.sweettastic.user"})
@EnableJpaRepositories(basePackages = {"com.sweettastic.admin", "com.sweettastic.cart", "com.sweettastic.category", "com.sweettastic.customer", "com.sweettastic.orderbill", "com.sweettastic.product", "com.sweettastic.sweetorder", "com.sweettastic.user"})
public class SweettasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweettasticApplication.class, args);
	}

}
