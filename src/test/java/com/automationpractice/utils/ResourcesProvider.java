package com.automationpractice.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public final class ResourcesProvider {

	private static final Path RESOURCE_PATH = Paths.get("src", "main", "resources", "files");

	private ResourcesProvider() {
	}

	public static String getPathOfResource(final String... resourcePath) {
		Arrays.stream(resourcePath).forEach(RESOURCE_PATH::resolve);
		return RESOURCE_PATH.toAbsolutePath().toString();
	}

	public static String getPathOfResource(final String fileName) {
		return RESOURCE_PATH.resolve(fileName).toAbsolutePath().toString();
	}
}
