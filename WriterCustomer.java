package com.bbva.mqwe.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.bbva.mqwe.dto.cliente.Customer;
import com.bbva.mqwe.lib.r01c.MQWER01C;

public class WriterCustomer implements ItemWriter<Customer>{

	private static Logger LOGGER = LoggerFactory.getLogger(WriterCustomer.class);
	//inyección
	private MQWER01C mqweR01C;
	
	@Override
	public void write(List<? extends Customer> listCustomer) throws Exception {
		
		LOGGER.info("Ejecutando Writer del proceso");
		//Para mejorar performance se debe mandar la lista completa a la librería
		//evitar el for y hacer un método que acepte una lista
		for(Customer customer : listCustomer) {
			mqweR01C.executeAddCustomer(customer);
		}
	}
	
	public MQWER01C getMqweR01C() {
		return mqweR01C;
	}

	public void setMqweR01C(MQWER01C mqweR01C) {
		this.mqweR01C = mqweR01C;
	}
	
}
