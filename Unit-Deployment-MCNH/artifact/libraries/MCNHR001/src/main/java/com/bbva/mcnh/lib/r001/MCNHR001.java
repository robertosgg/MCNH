package com.bbva.mcnh.lib.r001;

import java.util.List;
import java.util.Map;

import com.bbva.mcnh.dto.employees.EmployeesDTO;

/**
 * The  interface MCNHR001 class...
 */
public interface MCNHR001 {

	public EmployeesDTO excuteInsert(EmployeesDTO employee);
	public EmployeesDTO executeUpdate(EmployeesDTO employee);
	public void executeDeleteById (EmployeesDTO employeeDelete);
	public EmployeesDTO executeGetByName(EmployeesDTO employee);
	public List<EmployeesDTO> executeGetAllEmployee();

}
