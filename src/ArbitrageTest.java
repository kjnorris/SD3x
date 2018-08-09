import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArbitrageTest {

	@Test
	void testArbitrageOpportunity() {
		List<Integer> arbitrageOpportunities;
		try {
			arbitrageOpportunities = Arbitrage.arbitrageOpportunity("arbitrageTriangle.txt");
			assertNull(arbitrageOpportunities);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// fail("Not yet implemented");
	}

}
