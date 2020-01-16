package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Browsers {
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
	//public static ChromeDriverService service;
	public static DriverService service;

	private void takeScreenShot(WebDriver driver) throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
	}

	// Use Selenium 2.x.x // Firefox 4x.x
	//@Test
	public void testFirefox1() throws Exception {
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		// driver.get("http://regres.herokuapp.com/login");
		// driver.get("http://server7.pp.ua");
		// driver.get("https://auto.ria.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	// Use Selenium 3.x.x
	//@Test
	public void testFirefox1_3xx() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		//
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.id("navcnt"))).perform();
		Thread.sleep(2000);
		takeScreenShot(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.id("navcnt")));
		//driver.quit();
	}

	// Using default profile of firefox
	//@Test
	public void testFirefox2() throws Exception {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile("default-release");
		//
		profile.setAcceptUntrustedCertificates(true);
		// profile.setAssumeUntrustedCertificateIssuer(false);
		//profile.setPreference("app.update.enabled", false);
		// `
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		//
		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		// .setBinary("C:\\Windows\\System32\\calc.exe");
		// .setBinary("c:/Program Files/Nightly/firefox.exe")
		// .addArguments("-console");
		// .addPreference("browser.cache.disk.enable", false)
		// .addCapabilities(new DesiredCapabilities(ImmutableMap.of("pageLoadStrategy",
		// "eager")));
		WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
//		(new WebDriverWait(driver, 5)).until(ExpectedConditions
//				.visibilityOfElementLocated(By.linkText("2")));
		takeScreenShot(driver);
		//driver.quit();
	}

	//@Test
	public void testFirefox21() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		//
		FirefoxProfile profile = new FirefoxProfile(new File(
				//"C:\\Users\\yharasym\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\5cbpt6mc.default"));
				System.getenv("HOMEPATH") + "\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\teo7figz.default-release"));
		//
		//DesiredCapabilities dc = DesiredCapabilities.firefox();
		//dc.setCapability(FirefoxDriver.PROFILE, profile);
		//FirefoxDriver driver = new FirefoxDriver(dc);
		//
		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		// .setBinary("c:/Program Files/Nightly/firefox.exe")
		// .addArguments("-console")
		// .addPreference("browser.cache.disk.enable", false)
		// .addCapabilities(new DesiredCapabilities(ImmutableMap.of("pageLoadStrategy",
		// "eager")));
		WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
//		(new WebDriverWait(driver, 5)).until(ExpectedConditions
//				.visibilityOfElementLocated(By.linkText("2")));
		takeScreenShot(driver);
		//driver.quit();
	}
	
	// Use UntrustedCertificates
	//@Test
	public void testFirefox3() throws Exception {
//		 DesiredCapabilities capabilities = new DesiredCapabilities();
//		 capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		 System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
//		 WebDriver driver = new FirefoxDriver(capabilities);
		//
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // by default
		//options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		//
		//options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://192.168.195.249/Index#/Home");
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	// Do not use in Version 5x.x 
	//@Test
	public void testFirefox4() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		// File file = new File("lib/firepath-0.9.7.1-fx.xpi");
		//File file = new File("./lib/firebug-2.0.19-fx.xpi");
		// TODO Extension should contain either install.rdf or manifest.json metadata file
		//File file = new File("./lib/selenium_ide-3.3.1-an+fx.xpi");
		File file = new File("./lib/xpath_finder-0.9.7-fx.xpi");
		profile.addExtension(file);
		//
		profile.setAcceptUntrustedCertificates(true);
		//profile.setPreference("extensions.firebug.currentVersion", "2.0.19");
		//
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe"); // not working with firefox 53.0.3
		// WebDriver driver = new FirefoxDriver(profile);
		// WebDriver driver = new FirefoxDriver();
		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		// driver.quit();
	}

	//@Test // Log to console
	public void testFirefox5() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		//
		FirefoxOptions options = new FirefoxOptions()
		// .setBinary("c:/Program Files/Nightly/firefox.exe")
				.addArguments("-console");
		//if (isContinueIntegration()) {
		options.addArguments("--headless"); // Without UI
		//}
		WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		//element.sendKeys("Cheese!");
		element.sendKeys("Selenium Download");
		//System.out.println("sendKeys(Cheese!) DONE");
		// TODO
		//console.log("sendKeys(Cheese!)");
		element.submit();
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle());
//		(new WebDriverWait(driver, 5)).until(ExpectedConditions
//				.visibilityOfElementLocated(By.linkText("2")));
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	public void testInternetExplorer1() throws Exception {
//		System.setProperty("webdriver.ie.driver",
//				"C:\\Program Files\\Internet Explorer\\IEDriverServer64.exe");
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer32.exe");
		WebDriver driver = new InternetExplorerDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	//@Test // Do not working in Windows 10
	public void testInternetExplorer2() throws Exception {
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer32.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//		WebDriver driver = new InternetExplorerDriver(capabilities);
		//
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		//options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		WebDriver driver = new InternetExplorerDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	@Test // Do not working in Windows 10
	public void testEdge1() throws Exception {
		System.setProperty("webdriver.edge.driver",
				"./lib/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	//@Test
	public void testChrome1() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
                //this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("navcnt"))).perform();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	// chrome command line arguments https://peter.sh/experiments/chromium-command-line-switches/
	public void testChrome2() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		ChromeOptions options = new ChromeOptions();
		// chrome command line options
		// https://peter.sh/experiments/chromium-command-line-switches/
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--start-fullscreen");
		// options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		//
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test // ignore-certificate-errors Work by default!!!
	public void testChrome2_1Certificate() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
//		options.addArguments("--ignore-certificate-errors"); // Work by default!!!
		// options.addArguments("--disable-extensions");
		//options.addArguments("--disable-machine-cert-request");
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://192.168.195.249/Index#/Home");
		// driver.get("https://ita.edu.softserveinc.com/");
		// driver.get("http://www.google.com");
		// WebElement element = driver.findElement(By.name("q"));
		// element.sendKeys("Cheese!");
		// element.submit();
		//
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	// Now, working in Windows
	//@Test
	public void testChrome3UserProfile() throws Exception {
		System.out.println("HOME_PATH getenv = " + System.getenv("HOMEPATH"));
		// System.out.println("HOME_PATH Property = " +
		// System.getProperty("HOMEPATH"));
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		// String userProfile =
		// "C:\\Users\\yharasym\\AppData\\Local\\Google\\Chrome\\User
		// Data\\Default\\";
		String userProfile = System.getenv("HOMEPATH") + "\\AppData\\Local\\Google\\Chrome\\User Data";
		// + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
		System.out.println("PATH: " + userProfile);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--disable-extensions");
		// options.addArguments("\""+"user-data-dir=" + userProfile+"\""); // Work in
		// Linux, MacOS, etc. Do not working on Windows.
		options.addArguments("--user-data-dir=" + userProfile); // Working in Windows.
		// options.addArguments("--user-data-dir=" + userProfile); // Work in Linux,
		// MacOS, etc. Do not working on Windows.
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		// driver.quit();
	}

	//@Test
	public void testChrome4() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--disable-extensions");
		//
		// WebDriver driver = new ChromeDriver(options); // Comment
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//options.setBinary("C:\\Windows\\system32\\calc.exe");
		//options.setBinary("C:\\Windows\\notepad.exe");
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		// WebDriver driver = new ChromeDriver(capabilities);
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	// Chrome Without UI
	//@Test
	public void testChrome5() throws Exception {
		// Firefox https://developer.mozilla.org/en-US/Firefox/Headless_mode
		// Chrome https://peter.sh/experiments/chromium-command-line-switches/
		//System.setProperty("webdriver.chrome.driver",
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
//        System.setProperty("webdriver.chrome.driver",
//                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Chrome Without UI
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(1000);
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	// Use Selenium 2.52; Must be fixed for 3.x.x
	// Working properly by Selenium 3.14.0; // 3.141.59
	//@Test
	public void testHtmlUnit() throws Exception {
//		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
//                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless"); // Chrome Without UI
//		WebDriver driver = new ChromeDriver(options);
		//
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new HtmlUnitDriver(true);
		//((HtmlUnitDriver) driver).setJavascriptEnabled(true); // TODO Enable CSS
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.titleContains("Cheese"));
		// (new WebDriverWait(driver, 5)).until(
		// ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		System.out.println("\tPage title is: " + driver.getTitle());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		//Thread.sleep(2000);
		//takeScreenShot(driver); // Do not use!!!
		// driver.quit();
		driver.quit();
	}

	// Download from http://phantomjs.org/download.html
	// Download from phantomjsdriver-1.4.4.jar https://mvnrepository.com/artifact/com.codeborne/phantomjsdriver/1.4.4
	// Use Selenium 3.0.1, 3.x.x; Do not use Selenium 2.5.x
	//@Test
	public void testPhantomjs() throws Exception {
		System.setProperty("phantomjs.binary.path",
				"./lib/phantomjs.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new PhantomJSDriver();
		//WebDriver driver = new HtmlUnitDriver(true);
		driver.manage().window().maximize();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.titleContains("Cheese"));
		// (new WebDriverWait(driver, 5)).until(
		// ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		System.out.println("\tTaking First Screenshot ...");
		Thread.sleep(2000);
		takeScreenShot(driver);
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		//
		System.out.println("\tTaking Second Screenshot ...");
		// File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(scrFile, new File("./screenshot1.png"));
		Thread.sleep(2000);
		takeScreenShot(driver);
		System.out.println("\tDone Screenshot");
		//
		// driver.quit();
		driver.quit();
	}

	//@BeforeClass
	public void createService() throws Exception {
		service = new ChromeDriverService.Builder()
				//.usingDriverExecutable(new File("./lib/chromedriver.exe"))
				//.usingDriverExecutable(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"))
				.usingDriverExecutable(new File(this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath()))
				// .usingAnyFreePort()
				.usingPort(8888)
				.build();
		service.start();
		System.out.println("\t+++Service Start");
	}

	//@Test
	public void testRemout() throws Exception {
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-extensions");
		// WebDriver driver = new ChromeDriver(options);
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//
		// WebDriver driver = new RemoteWebDriver(new URL("127.0.0.1:8888"),
		// capabilities);
		WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
		System.out.println("\t+++RemoteWebDriver Start, service.getUrl()=" + service.getUrl());
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(4000);
		takeScreenShot(driver);
		driver.quit();
		System.out.println("\t+++driver.quit()");
	}

	//@AfterClass
	public void StopService() {
		if (service != null) {
			service.stop();
			System.out.println("\t+++RemoteWebDriver Stop");
		}
	}

}
