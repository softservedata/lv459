package com.softserve;

public class SimpleTest {

    //@Test
    public void myProbas() throws Exception {
        //    System.setProperty("webdriver.chrome.driver",
      //    "/usr/bin/chromedriver");
        //    System.setProperty("webdriver.chrome.driver",
        //                       this.getClass().getResource(Reg
        //                                                   "chromedriver*")
      //                                                   .getPath());
        //

        //  System.getenv().forEach((k, v) -> {
        //    System.out.println(k + ":" + v);
        //  });
        System.out.println(System.getenv("USER_PASSWORD"));

        Integer t= 4;
        String d = t.toString();
        System.out.println(d);

        //    System.out.println(System.getenv("DB_PASSWORD"));
        //    System.out.println(System.getenv("DB_LOGIN"));
        //    System.out.println(System.getenv("USER_EMAIL"));
        //
        //    System.out.println(this.getClass().getResource("chromedriver*")
      //    .getPath());

        //  System.setProperty("webdriver.chrome.driver" , this.getClass()
      //  .getResource("chromedriver").getPath());
        //    System.out.println(System.getProperty("webdriver.chrome.driver"));
    }
}
