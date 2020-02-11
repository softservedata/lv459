package com.softserve.edu.rest.test.cooldown;


import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.*;


public class InvalidCooldownTimeTest {

    private GuestService guestService;

    @BeforeClass
    public void adminRegistration() {
        GuestService guestService = new GuestService();
        guestService.successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.someNotAdminUser())
                .createUser(UserRepository.notExistingUser());
    }


    @DataProvider
    public Object[][] zeroLifetime() {
        return new Object[][]{
                {UserRepository.notExistingUser(), LifetimeRepository.getZeroLifetime()
                        , LifetimeRepository.getDefaultCooldownTime()}
        };
    }

    @Test(dataProvider = "zeroLifetime", expectedExceptions = RuntimeException.class)
    public void coolDownTimeWithZero(User admin, Lifetime lifetime, Lifetime defaultTime) {
        guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(admin)
                .changeCooldown(lifetime);
        Assert.assertNotEquals(userService.getCooldownTime().getTime(), defaultTime.getTime());
        userService.logout();
    }

    @DataProvider
    public Object[][] negativeNumberLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getNegativeLifetime(),
                        LifetimeRepository.getDefaultCooldownTime()}
        };
    }

    @Test(dataProvider = "negativeNumberLifetime", expectedExceptions = RuntimeException.class)
    public void coolDownTimeWithNegativeDigits(User admin, Lifetime lifetime, Lifetime defaultTime) {
        guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(admin)
                .changeCooldown(lifetime);
        Assert.assertEquals(userService.getCooldownTime().getTime(), defaultTime.getTime());
        userService.logout();
    }

}