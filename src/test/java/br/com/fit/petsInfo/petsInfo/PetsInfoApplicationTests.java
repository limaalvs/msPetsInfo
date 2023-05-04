package br.com.fit.petsInfo.petsInfo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fit.petsInfo.PetsInfoApplication;

@SpringBootTest
class PetsInfoApplicationTests {
	/*
	 * @Test void contextLoads() { }
	 */
	 
	@Test
	public void applicationContextLoaded() {
	}
	 @Test
	 void applicationContextTest() { 
		 PetsInfoApplication.main(new String[] {});
	 }

}
