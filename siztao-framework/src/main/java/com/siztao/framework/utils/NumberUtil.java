package com.siztao.framework.utils;

import java.text.DecimalFormat;

public class NumberUtil {
	
	private NumberUtil() {
		// 静态类不可实例化
	}
	
	/**
	 * 计算两数百分数
	 * @param divisor 除数
	 * @param dividend 被除数
	 * @return  51.2%
	 */
	public static String getPercent(int divisor, int dividend){
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(1);
		decimalFormat.setMinimumFractionDigits(1);
		if(divisor!=0){
			return decimalFormat.format(dividend * 100.00 / divisor) + "%";
		}else{
			return decimalFormat.format(0.00) + "%";
		}
	} 
	
	/**
	 * 格式化数字为千分位显示；
	 * @param 要格式化的数字；
	 * @return
	 */
	public static String fmtMicrometer(String text) {
		DecimalFormat df = null;
		if (text.indexOf('.') >= 0) {
			if (text.length() - text.indexOf('.') - 1 == 0) {
				df = new DecimalFormat("###,##0.");
			} else if (text.length() - text.indexOf('.') - 1 == 1) {
				df = new DecimalFormat("###,##0.0");
			} else {
				df = new DecimalFormat("###,##0.00");
			}
		} else {
			df = new DecimalFormat("###,##0");
		}
		double number = 0.0;
		try {
			number = Double.parseDouble(text);
		} catch (Exception e) {
			number = 0.0;
		}
		return df.format(number);
	}
}
