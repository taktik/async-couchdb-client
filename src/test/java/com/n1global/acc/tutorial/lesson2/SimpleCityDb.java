package com.n1global.acc.tutorial.lesson2;

import java.util.List;

import com.n1global.acc.CouchDb;
import com.n1global.acc.CouchDbConfig;
import com.n1global.acc.CouchDbConstants;

public class SimpleCityDb extends CouchDb {
    public SimpleCityDb(CouchDbConfig config) {
        super(config);
    }

    public List<City> suggest(String q) {
        return getBuiltInView().<City>createDocQuery().startKey(q)
                                                      .endKey(q + CouchDbConstants.LAST_CHAR)
                                                      .asDocs();
    }
}
