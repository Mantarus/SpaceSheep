package com.ottepel_hack.entities.embedded;

import javax.persistence.Embeddable;
import java.util.List;

/**
 * Created by iistomin on 18/03/17.
 */
@Embeddable
public class LevelMap {

    List<List<Byte>> map;

}
