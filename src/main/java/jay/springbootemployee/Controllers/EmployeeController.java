package jay.springbootemployee.Controllers;

import jay.springbootemployee.Models.Employee;
import jay.springbootemployee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    //SAVE
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    //READ
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> readEmployees(){
        return employeeService.getEmployees();
    }

    //DELETE
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
    }
}
