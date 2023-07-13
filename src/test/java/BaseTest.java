import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import businessComponents.TestGETAPI;
import businessComponents.TestPATCHAPI;
import businessComponents.TestPUTAPI;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class BaseTest {
	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	@Test
	public void testGETAPI() {
		BasicConfigurator.configure();
		logger.info("Test started..");
		TestGETAPI getAPI = new TestGETAPI();
		getAPI.getBookingIds();
		logger.info("Test Completed..");
	}

	@Test
	public void testPUTAPI() {
		BasicConfigurator.configure();
		logger.info("Test started..");
		TestPUTAPI putAPI = new TestPUTAPI();
		putAPI.Updatebooking();
		logger.info("Test Completed..");
	}

	@Test
	public void testPATCHAPI() {
		BasicConfigurator.configure();
		logger.info("Test started..");
		TestPATCHAPI patchAPI = new TestPATCHAPI();
		patchAPI.Updatebooking();
		logger.info("Test Completed..");
	}
}
