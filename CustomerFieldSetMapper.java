package com.bbva.mqwe.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.bbva.mqwe.dto.cliente.Customer;

public class CustomerFieldSetMapper implements FieldSetMapper<Customer>{
//job1 -> 
	@Override
	public Customer mapFieldSet(FieldSet fs) throws BindException {
		
		Customer customer=new Customer();
		customer.setIdPerson(fs.readLong("idPerson"));
		customer.setContractnumber(fs.readLong("contractnumber"));
		customer.setName(fs.readString("name"));
		customer.setEmail(fs.readString("email"));
		customer.setRfc(fs.readString("rfc"));
		customer.setLastname(fs.readString("lastname"));
		customer.setSurname(fs.readString("surname"));
		return customer;
	}
}