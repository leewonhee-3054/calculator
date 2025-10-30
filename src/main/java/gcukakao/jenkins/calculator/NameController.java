package gcukakao.jenkins.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class NameController {

	@Autowired
	private NameService nameService;

	@GetMapping("/name")
	public String name() {
		return nameService.getMyName();
	}
}