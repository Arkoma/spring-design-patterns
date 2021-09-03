package com.frankmoley.lil.designpatternsapp.singleton;

public class OldSchoolSingleton {
    private static OldSchoolSingleton instance;

    private OldSchoolSingleton() {
        super();
    }

    public static OldSchoolSingleton getInstance() {
        if (null == instance) {
            synchronized (OldSchoolSingleton.class) {
                if (null == instance) {
                    instance = new OldSchoolSingleton();
                }
            }
        }
        return instance;
    }
}
