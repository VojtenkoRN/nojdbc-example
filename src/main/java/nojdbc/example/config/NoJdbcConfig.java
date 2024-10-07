package nojdbc.example.config;

import jakarta.enterprise.context.Dependent;
import nojdbc.core.cache.RequestCache;

@Dependent
public class NoJdbcConfig {

    private static final RequestCache CACHE = RequestCache.getInstance();

    static {
        CACHE.setValidThresholdSeconds(1);
        CACHE.setUseThreshold(false);
    }

}
