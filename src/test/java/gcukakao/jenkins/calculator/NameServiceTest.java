package gcukakao.jenkins.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameServiceTest {

	@Test
	@DisplayName("본인 이름을 정확히 반환한다")
	void getMyName_shouldReturnRealName() {
		NameService nameService = new NameService();
		String expected = "당신의_이름_여기에"; // NameService와 동일한 본인 이름으로!
		assertEquals(expected, nameService.getMyName());
	}
}
