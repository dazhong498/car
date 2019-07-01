package by.pvt.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = "dao-config.xml")
@Configuration
public class Config {

    @Autowired
    BasicDataSource dataSource;

    @Bean(initMethod="migrate")
    public Flyway getFlyway() {
        Flyway flyway= new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("classpath:/flyway");
        flyway.setDataSource(ds);
        return flyway;
    }
}
