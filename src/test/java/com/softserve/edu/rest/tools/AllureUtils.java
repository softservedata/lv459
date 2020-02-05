package com.softserve.edu.rest.tools;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public final class AllureUtils {
	public static boolean isSaveJson = false; 

	private AllureUtils() {
    }

	public static void checkSaveJsonAttach(String attachName, String attachJson) {
		if (isSaveJson) {
			saveJsonAttach(attachName, attachJson);
		}
	}
	
	@Step("Save_JSON")
	@Attachment(value = "{0}", type = "text/plain")
	public static byte[] saveJsonAttach(String attachName, String attachJson) {
		return attachJson.getBytes();
	}
}
