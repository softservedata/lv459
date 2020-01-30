package com.softserve.edu.rest.dto;

public final class RestUrlRepository {
	private static String server = "http://localhost:8080";

	private RestUrlRepository() {
	}

//	public static RestUrl getAdminAuthorized() {
//		return new RestUrl()
//				.addBaseUrl(server)
//				.addGetUrl("/login/users")
//				.addPostUrl("/login")
//				.addPutUrl("")
//				.addDeleteUrl("/logout");
//		// .addDeleteUrl("/logout");
//	}

	public static RestUrl getUserAuthorized() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/login/users").addGetUrl("/login/admins") // getLoginedUsers, getLoginedAdmins
				.addPostUrl("/login").addPostUrl("/logout") // login, logout
				.addPutUrl("") // TODO Change Password
				.addDeleteUrl("") // run POST
				.addPatchUrl(""); // TODO Change Password
		// .addDeleteUrl("/logout");
	}

	public static RestUrl getApplication() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/reset")
				.addPostUrl("")
				.addPutUrl("")
				.addDeleteUrl("")
				.addPatchUrl("");
	}

	public static RestUrl getTokenLifetime() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/tokenlifetime")
				.addPostUrl("")
				.addPutUrl("/tokenlifetime")
				.addDeleteUrl("")
				.addPatchUrl("");
	}

	public static RestUrl getUserItem() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/item/{index}/user/{name}")
				.addPostUrl("")
				.addPutUrl("")
				.addDeleteUrl("")
				.addPatchUrl("");
	}

	public static RestUrl getItem() {
		return new RestUrl().addBaseUrl(server)
				.addGetUrl("/item/{index}")
				.addPostUrl("/item/{index}")
				.addPutUrl("/item/{index}")
				.addDeleteUrl("/item/{index}")
				.addPatchUrl("");
	}

}
