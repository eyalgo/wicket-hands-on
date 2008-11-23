package com.tikal.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tikal.HandsOnSession;

public final class GeneralFactory {
	// Suppress default constructor for noninstantiability
	private GeneralFactory() {
		throw new AssertionError("No instance for GeneralFactory");
	}

	public static List<Integer> createYearsRange() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1900; i < 2500; i++) {
			result.add(i);
		}
		return result;
	}

	public static List<Integer> createMonthsRange() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 12; i++) {
			result.add(i);
		}
		return result;
	}

	public static List<Integer> createDayRange() {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 31; i++) {
			result.add(i);
		}
		return result;
	}

	public static String getDatePattern() {
		return "dd-MM-yyyy";
	}

	public static SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat(getDatePattern(), HandsOnSession.get()
				.getLocale());
	}
}
