package com.ottepel_hack.managers;

/**
 * Created by iistomin on 18/03/17.
 */
public abstract class SolutionUtil {

    public static void addToSequence(String command) {
        SolutionManagerImpl.getActionSequence().getSequence().add(command);
    }

}
