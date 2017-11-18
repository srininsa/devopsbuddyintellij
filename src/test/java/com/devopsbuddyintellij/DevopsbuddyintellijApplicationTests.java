package com.devopsbuddyintellij;

import com.devopsbuddyintellij.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringRunner.class)
//@SpringBootTest

/**
 * during test this class starts up DevopsbuddyintellijApplication
 * and loads all Spring beans
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = DevopsbuddyintellijApplication.class)
@SpringBootApplication(scanBasePackageClasses = DevopsbuddyintellijApplication.class)
@WebAppConfiguration
public class DevopsbuddyintellijApplicationTests {

	@Autowired
	private I18NService i18NService;

	@Test
	public void testMessageByLocaleService() throws Exception {
		String expectedResult = "Bootstrap starter template";
		String messageId = "index.main.callout";
		String actual = i18NService.getMessage(messageId);
		Assert.assertEquals ("The actual and expected String don't match", expectedResult, actual);
	}


}
