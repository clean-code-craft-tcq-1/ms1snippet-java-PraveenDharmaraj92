package sensorval;

import java.util.List;

/**
 * Class for sensor parameter validation
 *
 */
public class SensorValidator {
	
	/**
	 * @param value - value 1
	 * @param nextValue - value 2, sequential to value 1
	 * @param maxDelta - maximum deviation allowed
	 * @return - true if difference between 2 values is not more than delta value 
	 */
	public static boolean isReadingNormal(double value, double nextValue, double maxDelta) {
		return (nextValue - value) < maxDelta;
	}

	/**
	 * @param values - list of values
	 * @param maxDelta - maximum deviation allowed 
	 * @return  true if no deviations in readings
	 */
	public static boolean validateReadings(List<Double> values, Double maxDelta) {

		if (values == null||values.isEmpty()) {
			return false;
		}

		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!isReadingNormal(values.get(i), values.get(i + 1), maxDelta)) {
				return false;
			}
		}
		return true;
	}

}