package com.cest.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UUIDUtil {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(uuid() + uuid());
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH:mm:ss")));
	}
}
