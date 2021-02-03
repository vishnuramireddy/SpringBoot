package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.EmpResponse;
import dto.Employee;

@RestController
public class EmpController {

	@RequestMapping("/hello")
	public String getHello() {
		return "Welcome to Spring Boot";// returns text
	}

	@RequestMapping("/hi")
	public String myData() {
		return "Hello Spring Boot"; // returns text
	}

	@RequestMapping(value = "/myjson", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<EmpResponse> getJson() {
		EmpResponse emp = new EmpResponse("success");
		return new ResponseEntity<EmpResponse>(emp, HttpStatus.OK); // returns response entity obj that has data +
																	// responsecode
	}

	@RequestMapping(value = "/myxml", method = RequestMethod.GET, produces = { "application/xml" })
	public ResponseEntity<EmpResponse> getXml() {
		EmpResponse emp = new EmpResponse("success");
		return new ResponseEntity<EmpResponse>(emp, HttpStatus.OK); // returns response entity obj that has data +
																	// responsecode
	}

	@RequestMapping(value = "/mydata", method = RequestMethod.GET, produces = { "application/xml", "application/json" })
	public ResponseEntity<EmpResponse> getData() {
		EmpResponse emp = new EmpResponse("success");
		return new ResponseEntity<EmpResponse>(emp, HttpStatus.OK); // returns response entity obj that has data +
																	// responsecode
	}

	@RequestMapping("/data/{id}")
	public String getResponseWithPath(@PathVariable("id") int id) {
		return "[getEmp] Hello User " + id;
	}

	@RequestMapping("/dataParam")
	public String getResponseWithUrl(@RequestParam("id") int id) {
		return "[getResponseWithUrl] Your id = " + id;
	}

	@RequestMapping(value = "/emp/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") int id) {
		Employee e = new Employee(1000 + id, "user" + id, id);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/{user}/{pass}", produces = { "application/json", "application/xml" })
	public ResponseEntity<EmpResponse> getEmpById(@PathVariable("user") String user,
			@PathVariable("pass") String pass) {
		if (user.equals(pass)) {
			EmpResponse emp = new EmpResponse("Login success");
			return new ResponseEntity<EmpResponse>(emp, HttpStatus.OK);
		} else {
			EmpResponse emp = new EmpResponse("Login failure");
			return new ResponseEntity<EmpResponse>(emp, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST, consumes = { "application/json", "application/xml" })
	public ResponseEntity<EmpResponse> createEmp(@RequestBody Employee emp) {
		return new ResponseEntity<>(new EmpResponse("emp created for " + emp), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emp", method = RequestMethod.PUT, consumes = { "application/json", "application/xml" })
	public ResponseEntity<EmpResponse> updateEmp(@RequestBody Employee emp) {
		return new ResponseEntity<>(new EmpResponse("emp updated for " + emp), HttpStatus.OK);
	}
}
