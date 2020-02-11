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

    public static Lifetime getDefaultCooldownTime() {
        return new Lifetime("180000");
    }

    public static Lifetime getNewCooldownTime() {
        return new Lifetime("200000");
    }

    public static Lifetime getZeroLifetime() {
        return new Lifetime("0");
    }

    public static Lifetime getTextLifetime() {
        return new Lifetime("SampleText");
    }

    public static Lifetime getSpecialSymbolLifetime() {
        return new Lifetime(":}{_-+");
    }

    public static Lifetime getNegativeLifetime() {
        return new Lifetime("-200000");
    }

    public static Lifetime getExtend() {
        return new Lifetime("900000");
    }

    public static Lifetime getShort() {
        return new Lifetime("5000");
    }
}
