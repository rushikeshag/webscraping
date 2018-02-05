package mfscraping.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public abstract class CommonUtil {// NOSONAR
	private CommonUtil() {
	}

	public static final Properties load(String fullPath) {
		InputStream resourceAsStream = resourceAsStream(fullPath);
		Properties props = new Properties();
		try {
			Objects.requireNonNull(resourceAsStream, "Cannot read from file:" + fullPath);
			props.load(resourceAsStream);
			return props;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static InputStream resourceAsStream(String fullPath) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(fullPath);
	}

	public static String resourceAsString(String fullPath) {
		InputStream resourceAsStream = resourceAsStream(fullPath);
		Scanner scanner = new Scanner(resourceAsStream);
		StringBuilder str = new StringBuilder();
		try {
			while (scanner.hasNext()) {
				String nextLine = scanner.nextLine();
				str.append(nextLine);
			}
		} finally {
			scanner.close();
		}
		return str.toString();
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		long tmp = Math.round(value * factor);
		return (double) tmp / factor;
	}
}
