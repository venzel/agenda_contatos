package utils;

import java.util.UUID;

public class GeradorId {

	public static String id() {
		return UUID.randomUUID().toString().split("-")[0];
	}
}