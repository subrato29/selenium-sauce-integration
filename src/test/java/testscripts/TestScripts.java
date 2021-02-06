package testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import com.app.keywords.Keywords;
import com.demo.base.DriverScript;

public class TestScripts extends DriverScript{
	@Test
	public void test1() throws NumberFormatException, IOException {
		String tcId = "TC001";
		if (isRunnable(tcId, 2)) {
			Keywords.findYourCity();
		}
	}
}
