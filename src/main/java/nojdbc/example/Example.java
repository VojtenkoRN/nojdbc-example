package nojdbc.example;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nojdbc.example.database.dao.MainDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class Example {

    private static final Logger LOG = LoggerFactory.getLogger(Example.class);

    @Inject
    MainDao mainDao;

    public void showSomeMagic() {
        final var allMain = mainDao.getAll();
        for (var main : allMain) {
            LOG.info("//-------//");
            LOG.info("{}", main);
        }
    }

}
