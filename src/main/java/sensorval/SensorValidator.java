package sensorval;

import java.util.List;

/**
 * Class for sensor parameter validation
 *
 */
public class SensorValidator {

	/**
	 * @param value
	 *            - value 1
	 * @param nextValue
	 *            - value 2, sequential to value 1
	 * @param maxDelta
	 *            - maximum deviation allowed
	 * @return - true if difference between 2 values is not more than delta
	 *         value
	 */
	public static boolean isReadingNormal(double value, double nextValue, double maxDelta) {
		return (nextValue - value) < maxDelta;
	}

	/**
	 * @param values
	 *            - list of values
	 * @param maxDelta
	 *            - maximum deviation allowed
	 * @return true if no deviations in readings
	 */
	public static boolean validateReadings(List<Double> values, Double maxDelta) {
		return !isNullorEmpty(values) && !isDeltaValueBreached(values, maxDelta);
	}

	/**
	 * @param values - value list
	 * @return true if null and not empty
	 */
	public static boolean isNullorEmpty(List<Double> values) {
		return values == null || values.isEmpty();
	}

	/**
	 * @param values - value list
	 * @param maxDelta - maximum deviation allowed
	 * @return  true if deviations are found in readings
	 */
	public static boolean isDeltaValueBreached(List<Double> values, Double maxDelta) {
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!isReadingNormal(values.get(i), values.get(i + 1), maxDelta)) {
				return true;
			}
		}
		return false;
	}

}