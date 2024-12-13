package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({

        "file:src/main/resources/test.properties"})
public interface Props extends Config {
    Props props = ConfigFactory.create(Props.class);

    @Config.Key("MORTYCHARACTER_URL")
    String mortyCharacterUrl();

    @Config.Key("USER_URL")
    String userUrl();
}
