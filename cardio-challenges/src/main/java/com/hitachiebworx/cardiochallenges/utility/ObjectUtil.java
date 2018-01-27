/*
 * @Author Mohammad Rafaee Bin Suhai
 * @CreatedDate 26/01/2018 * 
 */

package com.hitachiebworx.cardiochallenges.utility;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ObjectUtil {

	private static final Integer SCALE = 2;
	private static final int ROUND_TYPE = BigDecimal.ROUND_FLOOR;

	public static Double toDouble(Object source) {
		if (source != null) {
			Double result = null;
			if (source instanceof BigDecimal) {
				BigDecimal bd = ((BigDecimal) source);
				bd = bd.setScale(SCALE, ROUND_TYPE);
				result = bd.doubleValue();
			} else if (source instanceof BigInteger)
				result = ((BigInteger) source).doubleValue();
			else if (source instanceof Double)
				result = (Double) source;
			else if (source instanceof Float)
				result = ((Float) source).doubleValue();
			else if (source instanceof Long)
				result = ((Long) source).doubleValue();
			else if (source instanceof Integer)
				result = ((Integer) source).doubleValue();
			else if (source instanceof String)
				result = new Double((String) source);
			else
				result = 0d;
			return result;
		} else
			return 0d;
	}

	public static BigDecimal toBigDecimal(Object source) {
		BigDecimal result = BigDecimal.ZERO;
		if (source != null) {
			if (source instanceof BigInteger)
				result = new BigDecimal(((BigInteger) source).intValue());
			else if (source instanceof BigDecimal)
				result = ((BigDecimal) source);
			else if (source instanceof Double)
				result = new BigDecimal(((Double) source).toString());
			else if (source instanceof Float)
				result = new BigDecimal((Float) source);
			else if (source instanceof Long)
				result = new BigDecimal((Long) source);
			else if (source instanceof Integer)
				result = new BigDecimal((Integer) source);
			else if (source instanceof String)
				result = new BigDecimal((String) source);
			else
				result = BigDecimal.ZERO;

			result = result.setScale(SCALE, ROUND_TYPE);
		}

		return result;
	}

	public static Long toLong(Object source) {

		if (source != null) {
			Long result = null;
			if (source instanceof Long)
				result = (Long) source;
			if (source instanceof Integer)
				result = new Long((Integer) source);
			if (source instanceof String && !((String) source).isEmpty() && !((String) source).equalsIgnoreCase("null"))
				result = new Long(((String) source).trim());
			if (source instanceof BigDecimal)
				result = ((BigDecimal) source).longValue();
			if (source instanceof BigInteger)
				result = ((BigInteger) source).longValue();

			return result;
		} else
			return null;
	}

	public static Integer toInteger(Object source) {
		return source != null && toLong(source) != null ? toLong(source).intValue() : 0;
	}

	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}

			if (ret != null) {
				ret = ret.setScale(SCALE, ROUND_TYPE);
			}
		}
		return ret;
	}

	public static String toString(Object source) {

		if (source != null) {
			String result = null;
			if (source instanceof Long)
				result = ((Long) source).toString();
			else if (source instanceof String && !((String) source).isEmpty())
				result = ((String) source).trim();
			else if (source instanceof Integer)
				result = ((Integer) source).toString();
			else if (source instanceof BigDecimal) {
				BigDecimal bd = (BigDecimal) source;
				result = bd.toString();
			} else if (source instanceof BigInteger)
				result = ((BigInteger) source).toString();
			return result != null && !result.isEmpty() ? result : null;
		} else
			return null;
	}

	public static Boolean toBoolean(Object source) {

		if (source != null) {
			Boolean result = null;
			if (source instanceof Boolean)
				result = (Boolean) source;
			if (source instanceof String && !((String) source).isEmpty())
				result = "true".equalsIgnoreCase((String) source);

			return result != null ? result : null;
		} else
			return null;
	}
	
	public static Boolean notNull(Object source) {
		if (source != null) {
			Boolean result = false;
			
			if (source instanceof String) {
				result = !((String) source).isEmpty();
			}else if (source instanceof Long) {
				result = ((Long) source) > 0;
			}else if (source instanceof Integer) {
				result = ((Integer) source) > 0;
			} 
			
			return result;
		}else return false;
			
	}

}
