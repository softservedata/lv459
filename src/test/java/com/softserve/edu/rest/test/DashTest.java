package com.softserve.edu.rest.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class SimpleEntity {

	private String content;

	public SimpleEntity(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "SimpleEntity [content=" + content + "]";
	}
}

public class DashTest {

	// @Test
	public void checkSuccessful() throws Exception {
		Gson gson = new Gson();
		SimpleEntity simpleEntity;
		String token;
		String lifeTime;
		String result;
		//
		OkHttpClient client = new OkHttpClient();
		RequestBody formBody;
		Request request;
		Response response;
		String resultJson;
		//
		// Get TokenLifetime
		request = new Request
				.Builder()
				.url("http://localhost:8080/tokenlifetime")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		lifeTime = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		Assert.assertEquals(lifeTime, "300000");
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
		// Login
		formBody = new FormBody.Builder()
				.add("name", "admin")
				.add("password", "qwerty")
				.build();
		request = new Request.Builder()
				.url("http://localhost:8080/login")
				.post(formBody)
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		token = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
		// Update TokenLifetime
		formBody = new FormBody.Builder()
				.add("token", token)
				.add("time", "901000")
				.build();
		request = new Request.Builder()
				.url("http://localhost:8080/tokenlifetime")
				.put(formBody)
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		lifeTime = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		Assert.assertEquals(lifeTime, "true");
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
		// Get NEW TokenLifetime
		request = new Request.Builder()
				.url("http://localhost:8080/tokenlifetime")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		lifeTime = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		Assert.assertEquals(lifeTime, "901000");
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
		// Logout
		formBody = new FormBody.Builder()
				.add("name", "admin")
				.add("token", token)
				.build();
		request = new Request.Builder()
				.url("http://localhost:8080/logout")
				.post(formBody)
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		result = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
		// Reset Server
		request = new Request.Builder()
				.url("http://localhost:8080/reset")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		simpleEntity = gson.fromJson(resultJson, SimpleEntity.class);
		result = simpleEntity.getContent();
		//
		Assert.assertTrue(response.isSuccessful());
		Assert.assertEquals(result, "true");
		System.out.println("resultJson: " + resultJson);
		System.out.println("simpleEntity: " + simpleEntity);
		//
	}

	class GitHubSimple {

		private String login;
		private String id;
		private String name;

		public GitHubSimple(String login, String id, String name) {
			this.login = login;
			this.id = id;
			this.name = name;
		}

		public String getLogin() {
			return login;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "GitHubSimple ["
					+ " login=" + login
					+ ", id=" + id
					+ ", name=" + name
					+ " ]";
		}
	}
	
	//@Test
	public void checkGithubSimple() throws Exception {
		Gson gson = new Gson();
		GitHubSimple gitHubSimple;
		//
		OkHttpClient client = new OkHttpClient();
		Request request;
		Response response;
		String resultJson;
		//
		// Get TokenLifetime
		request = new Request.Builder()
				.url("https://api.github.com/users/nikita-pivovarov")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		gitHubSimple = gson.fromJson(resultJson, GitHubSimple.class);
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("gitHubSimple: " + gitHubSimple);
		//
	}

	class GitHubDifficult {

		private String description;
		private String homepage;
		private String language;

		public GitHubDifficult(String description, String homepage, String language) {
			this.description = description;
			this.homepage = homepage;
			this.language = language;
		}

		public String getDescription() {
			return description;
		}

		public String getHomepage() {
			return homepage;
		}

		public String getLanguage() {
			return language;
		}

		@Override
		public String toString() {
			return "\ngitHubDifficult ["
					+ " description=" + description
					+ ", homepage=" + homepage
					+ ", language=" + language
					+ " ]";
		}
	}
	
	//@Test
	public void checkGithubDifficult() throws Exception {
		Gson gson = new Gson();
		List<GitHubDifficult> gitHubDifficult;
		//
		OkHttpClient client = new OkHttpClient();
		Request request;
		Response response;
		String resultJson;
		//
		// Get TokenLifetime
		request = new Request.Builder()
				.url("https://api.github.com/orgs/dotnet/repos")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		gitHubDifficult = gson.fromJson(resultJson, new TypeToken<List<GitHubDifficult>>(){}.getType());
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("gitHubSimple: " + gitHubDifficult);
		//
	}

	public class Owner {
		private String login;
		private String type;

		public Owner(String login, String type) {
			this.login = login;
			this.type = type;
		}

		public String getLogin() {
			return login;
		}

		public String getType() {
			return type;
		}

		@Override
		public String toString() {
			return "\nOwner ["
					+ " login =" + login
					+ ", type =" + type
					+ " ]";
		}
	
	}
	
	public class GitHubDifficultInnerClass {
		
		private Owner owner;
		private Integer id;
		private String description;
		private String homepage;
		private String language;

		public GitHubDifficultInnerClass() {}
		
		public GitHubDifficultInnerClass(Owner owner, Integer id, String description, String homepage, String language) {
			this.owner = owner;
			this.id = id;
			this.description = description;
			this.homepage = homepage;
			this.language = language;
		}
		
		public Owner getOwner() {
			return owner;
		}

		public Integer getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		public String getHomepage() {
			return homepage;
		}

		public String getLanguage() {
			return language;
		}

		@Override
		public String toString() {
			return "\nGitHubDifficultInnerClass ["
					+ " owner=" + owner.toString()
					+ " id =" + id
					+ " description =" + description
					+ ", homepage =" + homepage
					+ ", language =" + language
					+ " ]";
		}
	}
	
	@Test
	public void checkGithubDifficultInnerClass() throws Exception {
		Gson gson = new Gson();
		List<GitHubDifficultInnerClass> gitHubDifficultInnerClass;
		//
		OkHttpClient client = new OkHttpClient();
		Request request;
		Response response;
		String resultJson;
		//
		// Get TokenLifetime
		request = new Request.Builder()
				.url("https://api.github.com/orgs/dotnet/repos")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		gitHubDifficultInnerClass = gson.fromJson(resultJson, new TypeToken<List<GitHubDifficultInnerClass>>(){}.getType());
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("gitHubSimple: " + gitHubDifficultInnerClass);
		//
	}

}
