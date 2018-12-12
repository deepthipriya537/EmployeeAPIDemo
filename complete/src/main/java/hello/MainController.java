package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    
@RequestMapping(path="/demo") 
public class MainController {
	@Autowired 
	private EmployeeRepository empRepository;

	@PostMapping(path="/add/{name}/{email}") 
	public @ResponseBody String addEmployee (@PathVariable("name") String name
			, @PathVariable("email") String email) {

		Employee n = new Employee();
		n.setName(name);
		n.setEmail(email);
		empRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		// This returns a JSON or XML with the users
		return empRepository.findAll();
	}
}