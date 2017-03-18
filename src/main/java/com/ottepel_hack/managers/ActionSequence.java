package com.ottepel_hack.managers;

import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
public class ActionSequence {

    private List<String> sequence;

    public ActionSequence(List<String> sequence) {
        this.sequence = sequence;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
