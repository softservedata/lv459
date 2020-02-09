package com.softserve.edu.rest.test.cooldown;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCooldownTimeWithNoRightsTest {
    @DataProvider
    public Object[][] notExData() {
        return new Object[][]{
                {UserRepository.notExistingUser(), LifetimeRepository.getNewCooldownTime()}
        };
    }

    @Test(dataProvider = "notExData", expectedExceptions = RuntimeException.class)
    public void changeCoolDownTimeAsUser(User notexistingUser, Lifetime newLifeTime) {
        GuestService guestService = new GuestService();
        UserService user = guestService
                .successfulAdminLogin(notexistingUser)
                .changeCooldown(newLifeTime);
        Assert.assertNotEquals(user.getCooldownTime().getTime(), newLifeTime.getTime());
    }

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {UserRepository.someNotAdminUser(), LifetimeRepository.getNewCooldownTime(),
                        LifetimeRepository.getDefaultCooldownTime()}
        };
    }

    @Test(dataProvider = "userData", expectedExceptions = RuntimeException.class)
    public void changeCoolDownTimeAsUser(User user, Lifetime newLifetime, Lifetime defaultLifetime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService.successfulAdminLogin(user)
                .changeCooldown(newLifetime);
        Assert.assertEquals(defaultLifetime.getTime(), userService.getCooldownTime().getTime());
    }
}
