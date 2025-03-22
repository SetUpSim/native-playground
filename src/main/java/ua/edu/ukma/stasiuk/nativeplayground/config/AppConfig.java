package ua.edu.ukma.stasiuk.nativeplayground.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ua.edu.ukma.stasiuk.nativeplayground.repository")
@ComponentScan("ua.edu.ukma.stasiuk.nativeplayground")
@EntityScan("ua.edu.ukma.stasiuk.nativeplayground.domain")
public class AppConfig {
}
