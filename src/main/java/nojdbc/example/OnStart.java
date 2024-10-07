package nojdbc.example;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class OnStart {

    @Inject
    Example example;

    void onStart(@Observes StartupEvent ev) {
        example.showSomeMagic();
    }

}
