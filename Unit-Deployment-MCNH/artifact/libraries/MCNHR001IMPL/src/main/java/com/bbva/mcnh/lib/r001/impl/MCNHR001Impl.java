package com.bbva.mcnh.lib.r001.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.apx.exception.db.DuplicateKeyException;
import com.bbva.apx.exception.db.NoResultException;
import com.bbva.apx.exception.db.TimeoutException;
import com.bbva.mcnh.dto.employees.EmployeesDTO;


/**
 * The MCNHR001Impl class...
 */
public class MCNHR001Impl extends MCNHR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(MCNHR001Impl.class);

	@Override
	public EmployeesDTO excuteInsert(EmployeesDTO employee) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Entrando al metodo executeInsert Employee");
		
		String email=employee.getEmployeeEmail();
		String rfc=employee.getEmployeeRfc();
		rfc=rfc.toUpperCase().trim();
		
		if(validacion(rfc,email)) {
			LOGGER.info("Validaciones Correctas");
				
				 int result=0;
					try {
						result = this.jdbcUtils.update("insert",employee.getEmployeeNumber(),employee.getEmployeeName(),employee.getEmployeeDepartament(),
								rfc,employee.getEmployeeEmail(),employee.getEmployeePhone(),employee.getEmployeeAddress(),employee.getEmployeeRegistrationDate(),
								employee.getEmployeeStatus(),employee.getSalary());
					}catch(DuplicateKeyException e){
						LOGGER.error("Ocurrio un problema, se duplico el key en la tabla Employees");
						addAdvice("MCNH01317004");
					}
					catch(TimeoutException e) {
						LOGGER.error("Ocurrio un problema, se excedio el tiempo para iinsertar en la tabla employees");
						addAdvice("MCNH01317005");
					}
					LOGGER.info("El resultado del insert es {}",result);
					return employee;

		
		}else {
			LOGGER.error("Validaciones Invalidas");
			return null;
		}
	}

	@Override
	public EmployeesDTO executeUpdate(EmployeesDTO employee) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Entrando al metodo execUpdate");
		
		String email=employee.getEmployeeEmail();
		String rfc=employee.getEmployeeRfc();
		rfc=rfc.toUpperCase().trim();
		
		if(validacion(rfc,email)) {
			LOGGER.info("Validaciones Correctas");
		
			int result=0;
			
			try {
				Map<String,Object> params = new HashMap<>();
				params.put("id", employee.getEmployeeNumber());
				params.put("name", employee.getEmployeeName());
				params.put("departament", employee.getEmployeeDepartament());
				params.put("rfc",rfc);
				params.put("email", employee.getEmployeeEmail());
				params.put("phone", employee.getEmployeePhone());
				params.put("address", employee.getEmployeeAddress());
				params.put("registrationDate", employee.getEmployeeRegistrationDate());
				params.put("status", employee.getEmployeeStatus());
				params.put("salary", employee.getSalary());
				
				result = this.jdbcUtils.update("update",params);
				
			}catch(DuplicateKeyException e) {
				LOGGER.error("Ocurrio un error, se duplico el key en la tabla employeer");
				addAdvice("MCNH01317004");
			}catch(TimeoutException e) {
				LOGGER.error("Ocurrio un error, se excedio el tiempo para actualizar la tabla employees");
				addAdvice("MCNH01317005");
			}
			LOGGER.info("El resultado del update es {}",result);
			return employee;
			
		}else {
			LOGGER.error("Validaciones Invalidas");
			return null;
		}
	}

	@Override
	public void executeDeleteById(EmployeesDTO employeeDelete) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Entrando al metodo de Eliminacion");
		
		int result=0;
		
		try {
			
			Map<String,Object> params = new HashMap<>();
			params.put("id", employeeDelete.getEmployeeNumber());
			result = this.jdbcUtils.update("delete",params);
			
		}catch(DuplicateKeyException e) {
			
			LOGGER.error("Ocurrio un error, se duplico el key en la tabla employeer");
			addAdvice("MCNH01317004");
			
		}catch(TimeoutException e) {
			
			LOGGER.error("Ocurrio un error, se excedio el tiempo para actualizar la tabla employees");
			addAdvice("MCNH01317005");
		}
		
		LOGGER.info("El resultado de la eliminación es {}",result);
	}

	
	@Override
	public EmployeesDTO executeGetByName(EmployeesDTO employee) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Entrando al metodo ExecuteGetByName");
		EmployeesDTO cliente= new EmployeesDTO();
		
		try {
			
			Map<String,Object> params = new HashMap<>();
			params.put("name", employee.getEmployeeName());
			
			List<Map<String,Object>> lista= new ArrayList<Map<String,Object>>(); 
			lista=this.jdbcUtils.queryForList("getEmployee",params);
			
			if(lista.size()>1) {
				
				LOGGER.info("Entrando a buscar Registro de Employee");
				for(Map<String,Object> map: lista ) {
					if(employee.equals(map.get("employee_name").toString())) {
						
						cliente.setEmployeeNumber(Integer.parseInt(map.get("employee_number").toString()));
						cliente.setEmployeeName(map.get("employee_name").toString());
						cliente.setEmployeeDepartament(map.get("employee_department").toString());
						cliente.setEmployeeRfc(map.get("employee_rfc").toString());
						cliente.setEmployeeEmail(map.get("employee_email").toString());
						cliente.setEmployeePhone(map.get("employee_phone").toString());
						cliente.setEmployeeAddress(map.get("employee_address").toString());
						cliente.setEmployeeRegistrationDate((Date) map.get("employee_registration_date"));
						cliente.setEmployeeStatus(Integer.parseInt(map.get("employee_status").toString()));
						cliente.setSalary(Integer.parseInt(map.get("salary").toString()));
											
						break;
					}					
				}
				
				LOGGER.info("Saliendo del if de buscar registro");
			}else {
				LOGGER.info("Entrando al else");
				
				cliente.setEmployeeNumber(Integer.parseInt(lista.get(0).get("employee_number").toString()));
				cliente.setEmployeeName(lista.get(0).get("employee_name").toString());
				cliente.setEmployeeDepartament(lista.get(0).get("employee_department").toString());
				cliente.setEmployeeRfc(lista.get(0).get("employee_rfc").toString());
				cliente.setEmployeeEmail(lista.get(0).get("employee_email").toString());
				cliente.setEmployeePhone(lista.get(0).get("employee_phone").toString());
				cliente.setEmployeeAddress(lista.get(0).get("employee_address").toString());
				cliente.setEmployeeRegistrationDate((Date) lista.get(0).get("employee_registration_date"));
				cliente.setEmployeeStatus(Integer.parseInt(lista.get(0).get("employee_status").toString()));
				cliente.setSalary(Integer.parseInt(lista.get(0).get("salary").toString()));
							
			}
			
			LOGGER.info("Saliendo del else");
		}catch( NoResultException e) {
			
			LOGGER.error("No hay resultados de la tabla employees");
			addAdvice("MCNH01317008");
					
		}
		
		LOGGER.info("Saliendo del metodo ExecuteGetByName");
		return cliente;

	}

	@Override
	public List<EmployeesDTO> executeGetAllEmployee() {
		// TODO Auto-generated method stub

		List<EmployeesDTO> lista2 = new LinkedList<EmployeesDTO>();
		List<Map<String,Object>> lista= new ArrayList<Map<String,Object>>(); 
		lista=this.jdbcUtils.queryForList("getAllEmployees");
		
		for(Map<String,Object> map: lista ) {
				EmployeesDTO cliente= new EmployeesDTO();	
				cliente.setEmployeeNumber(Integer.parseInt(map.get("employee_number").toString()));
				cliente.setEmployeeName(map.get("employee_name").toString());
				cliente.setEmployeeDepartament(map.get("employee_department").toString());
				cliente.setEmployeeRfc(map.get("employee_rfc").toString());
				cliente.setEmployeeEmail(map.get("employee_email").toString());
				cliente.setEmployeePhone(map.get("employee_phone").toString());
				cliente.setEmployeeAddress(map.get("employee_address").toString());
				cliente.setEmployeeRegistrationDate((Date) map.get("employee_registration_date"));
				cliente.setEmployeeStatus(Integer.parseInt(map.get("employee_status").toString()));
				cliente.setSalary(Integer.parseInt(map.get("salary").toString()));		
				
				lista2.add(cliente);
		}
		
		return lista2;
	}
	
	public boolean validacion(String rfc,String email) 
	{
		boolean validar=true;
		
		if(validarRfc(rfc)) {
			LOGGER.info("El RFC "+rfc+" es Valido");
		}else {
			validar=false;
			LOGGER.error("El RFC "+rfc+" es Invalido");
		}
		
		if(validarEmail(email)) {
			 LOGGER.info("El Email "+email+" es Valido");
		}else {
			validar=false;
			LOGGER.error("El Email "+email+" es Invalido");
		}
		return validar;
		
	}
	
	public boolean validarRfc(String rfc){
		rfc=rfc.toUpperCase().trim();
		return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
	}
	
	public boolean validarEmail(String email){
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
}
