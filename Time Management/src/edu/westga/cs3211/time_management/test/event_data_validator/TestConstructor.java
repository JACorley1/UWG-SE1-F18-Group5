package edu.westga.cs3211.time_management.test.event_data_validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.EventDataValidator;

class TestConstructor {

	@Test
	void test() {
		EventDataValidator validator = new EventDataValidator(); 
		assertEquals(validator, new EventDataValidator());
	}

}
