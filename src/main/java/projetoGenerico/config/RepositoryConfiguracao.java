package projetoGenerico.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"projetoGenerico"})
@EnableJpaRepositories(basePackages = {"projetoGenerico"})
@EnableTransactionManagement
public class RepositoryConfiguracao {

}
