package edu.example.board_user.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HikariCPConfig {

  @Value("${spring.datasource.username}")
  private String username;

  @Value("${spring.datasource.password}")
  private String password;

  @Value("${spring.datasource.url}")
  private String url;

  @Bean
  public DataSource dataSource() {
    HikariConfig hikariConfig = new HikariConfig();

    hikariConfig.setUsername(username);
    hikariConfig.setPassword(password);
    hikariConfig.setJdbcUrl(url);
    hikariConfig.setConnectionTestQuery("SELECT 1");
    hikariConfig.setMaximumPoolSize(100);
    hikariConfig.setLeakDetectionThreshold(30000);
    hikariConfig.setPoolName("Mariadb-HikariCP");

    return new HikariDataSource(hikariConfig);
  }

}
