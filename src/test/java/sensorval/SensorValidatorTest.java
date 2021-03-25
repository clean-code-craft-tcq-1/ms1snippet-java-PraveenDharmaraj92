package sensorval;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest {
	@Test
	public void testSocReadingsValidation() {
		Double[] readings = { 0.0, 0.01, 0.5, 0.51 };
		List<Double> socs = Arrays.asList(readings);
		assertFalse(SensorValidator.validateReadings(socs, 0.05));
	}

	@Test
	public void testCurrentReadingsValidation() {
		Double[] readings = { 0.03, 0.03, 0.03, 0.33 };
		List<Double> currents = Arrays.asList(readings);
		assertFalse(SensorValidator.validateReadings(currents, 0.1));
	}

	@Test
	public void testReadingsValidationWithNullInput() {
		assertFalse(SensorValidator.validateReadings(null, 0.1));
	}

	@Test
	public void testReadingsValidationWithEmptyInput() {
		assertFalse(SensorValidator.validateReadings(new ArrayList<Double>(), 0.1));
	}
	
	@Test
	public void testValueBreach(){
		Double[] readings = { 0.0, 0.01, 0.5, 0.51 };
		List<Double> valueList = Arrays.asList(readings);
		assertTrue(SensorValidator.isDeltaValueBreached(valueList, 0.1));
	}

}