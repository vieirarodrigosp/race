package vieirabarbosa.com.br.race.business.object;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class RaceBOTest {
//	@Rule public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
	@InjectMocks
	RaceBO raceBO;
	@Mock
	WinnerBO winnerBO;
//	@Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//	@Test
//	public void getWinnerSucess() throws IOException {
//		assertNotNull(raceBO.getWinner("corridaMock.log"));
//	}
}
