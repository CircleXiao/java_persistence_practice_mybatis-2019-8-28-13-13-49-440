package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.model.Employee;

@Mapper
public interface EmployeeMapper {
	@Insert("insert into employee values(#{id}, #{name}, #{age})")
	void insertEmployee(Employee employee);
	
	@Select("select * from employee")
	List<Employee> selectEmployees();

	@Update("update employee set id = #{id}, name = #{name}, age = #{age} where id = #{id}")
	void updateEmployee(Employee employee);
	
	@Delete("delete from employee where id = #{id}")
	void deleteEmployee(int id);

	@Select("select * from employee where id = #{id}")
	Employee selectSingleEmployee(int id);
}
