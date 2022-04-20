package com.bbva.mcnh;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.mcnh.dto.employees.EmployeesDTO;
import com.bbva.mcnh.lib.r001.MCNHR001;

/**
 * TRX Proyecto Final APX Onliine
 *
 */
public class MCNHT00101MXTransaction extends AbstractMCNHT00101MXTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(MCNHT00101MXTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		MCNHR001 mcnhR001 = this.getServiceLibrary(MCNHR001.class);
		// TODO - Implementation of business logic
		
		String entrada=this.getEntrada();
		if("0".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion Insertar");
			EmployeesDTO employees = mcnhR001.excuteInsert(getEmployeesin());
			setEmployeesout(employees);
			LOGGER.info("Saliendo de la operación insertar");
			
		} else if("1".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de actualizar");
			EmployeesDTO employees = mcnhR001.executeUpdate(getEmployeesin());
			setEmployeesout(employees);
			LOGGER.info("Saliendo de la operación de actualizar");
			
		}else if("2".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de Eliminar");
			mcnhR001.executeDeleteById(getEmployeesin());
			LOGGER.info("Saliendo de la operación de Eliminar");
			
		}else if("3".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de consulta por nombre");
			EmployeesDTO employees = mcnhR001.executeGetByName(getEmployeesin());
			setEmployeesout(employees);
			LOGGER.info("Saliendo de la operación de consulta por nombre");
			
		}else if("4".equals(entrada)) {
			
			LOGGER.info("Entre a la operacion de consulta de todos employees ");
			List<EmployeesDTO> lista= mcnhR001.executeGetAllEmployee();
			setLista(lista);
			LOGGER.info("Saliendo de la operación de consulta de todos employees");
			
		}
		Advice advice = getAdvice();
		if(advice!=null && "MCNH01J317000".equals(advice.getCode())) {
			setSeverity(Severity.ENR);
		}else {
			setSeverity(Severity.OK);
			LOGGER.info("La operación termino de manera exitosa");
		}
	}

}
