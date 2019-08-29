package tws.controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.mapper.EmployeeMapper;
import tws.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping
	public List<Employee> queryEmployees() {
		return employeeMapper.selectEmployees();
	}
	
	@GetMapping(path = "/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		return employeeMapper.selectSingleEmployee(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employeeMapper.insertEmployee(employee);
	}
	
	@PutMapping(path = "/{id}")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeMapper.updateEmployee(employee);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeMapper.deleteEmployee(id);
	}

}
