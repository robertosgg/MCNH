package com.bbva.mcnh;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.mcnh.dto.employees.EmployeesDTO;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractMCNHT00101MXTransaction extends AbstractTransaction {

	public AbstractMCNHT00101MXTransaction(){
	}


	/**
	 * Return value for input parameter entrada
	 */
	protected String getEntrada(){
		return (String)this.getParameter("entrada");
	}

	/**
	 * Return value for input parameter employeesIn
	 */
	protected EmployeesDTO getEmployeesin(){
		return (EmployeesDTO)this.getParameter("employeesIn");
	}

	/**
	 * Set value for EmployeesDTO output parameter employeesOut
	 */
	protected void setEmployeesout(final EmployeesDTO field){
		this.addParameter("employeesOut", field);
	}

	/**
	 * Set value for List<EmployeesDTO> output parameter lista
	 */
	protected void setLista(final List<EmployeesDTO> field){
		this.addParameter("lista", field);
	}
}
