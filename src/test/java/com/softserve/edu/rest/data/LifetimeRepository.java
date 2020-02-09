package com.softserve.edu.rest.data;

public final class LifetimeRepository {

    private LifetimeRepository() {
    }

    public static Lifetime getDefault() {
        return getTypical();
    }

    public static Lifetime getTypical() {
        return new Lifetime("300000");
    }

    public static Lifetime getExtend() {
        return new Lifetime("900000");
    }

    public static Lifetime getShort() {
        return new Lifetime("5000");
    }

    public static Lifetime getDefaultCooldownTime() {
        return new Lifetime("180000");
    }

    public static Lifetime getNewCooldownTime() {
        return new Lifetime("200000");
    }

}
