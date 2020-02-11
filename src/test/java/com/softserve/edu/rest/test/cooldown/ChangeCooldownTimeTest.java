package com.softserve.edu.rest.test.cooldown;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCooldownTimeTest {
    private GuestService guestService;

    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                {UserRepository.getAdmin()}
        };
    }

    @Test(dataProvider = "user")
    public void checkCooldownTime(User admin) {
        guestService = new GuestService();
        Assert.assertEquals(guestService
                .successfulUserLogin(admin)
                .getCooldownTime()
                .getTimeAsText(), "180000");
    }

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getDefaultCooldownTime(),
                        LifetimeRepository.getNewCooldownTime()},
        };
    }

    //@Test(dataProvider = "correctUser")
    public void coolDownTimeChangeTest(User user, Lifetime lifetime, Lifetime defaultTime) {
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCooldown(lifetime);
        Assert.assertNotEquals(userService.getCooldownTime().getTime(), defaultTime.getTime());
    }

    @AfterMethod
    public void setCoolDownTimeForDefault() {
        guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCooldown(LifetimeRepository.getDefaultCooldownTime());
        Assert.assertEquals(guestService.getCooldownTime().getTime(),
                LifetimeRepository.getDefaultCooldownTime().getTime());
    }

//


}
