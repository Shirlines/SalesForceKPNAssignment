package com.KPNSf.utils;

public class ResourceUtils {

	public static String getResourcePath(String resourceName) {
		String path = getBasePath() + resourceName;
		return path;
	}

	public static String getBasePath() {
		String path = ResourceUtils.class.getClassLoader().getResource(".").getPath();
		return path;
	}

}
