package com.softserve.edu.rest.test.cooldown;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCooldownTimeTest {

    private GuestService guestService;

    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getDefaultCooldownTime()}
        };
    }

    @Test(dataProvider = "user")
    public void checkCooldownTime(User admin, Lifetime defaultTime) {
        guestService = new GuestService();
        Assert.assertEquals(guestService
                .successfulUserLogin(admin)
                .getCooldownTime()
                .getTimeAsText(), defaultTime.getTimeAsText());
    }

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getDefaultCooldownTime(),
                        LifetimeRepository.getNewCooldownTime()},
        };
    }

    @Test(dataProvider = "correctUser")
    public void coolDownTimeChangeTest(User admin, Lifetime defaultTime, Lifetime lifetime) {
        guestService = new GuestService();
        guestService.successfulAdminLogin(admin)
                .changeCooldown(lifetime);
        Assert.assertNotEquals(guestService.getCooldownTime().getTime(), defaultTime.getTime());
    }

    @AfterClass
    public void setCoolDownTimeForDefault() {
        guestService = new GuestService();
        guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCooldown(LifetimeRepository.getDefaultCooldownTime());
        Assert.assertEquals(guestService.getCooldownTime().getTime(),
                LifetimeRepository.getDefaultCooldownTime().getTime());
    }

}
