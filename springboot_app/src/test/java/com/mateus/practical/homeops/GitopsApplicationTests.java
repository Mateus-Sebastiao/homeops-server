package com.mateus.practical.homeops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles; // Added it

@SpringBootTest
@ActiveProfiles("test") // Added it
class GitopsApplicationTests {

	@Test
	void contextLoads() {
	}

}