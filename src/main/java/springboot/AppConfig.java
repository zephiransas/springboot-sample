package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class AppConfig {

	@Autowired
	DataSourceProperties properties;

	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() throws URISyntaxException {
		String url;
		String username;
		String password;

		String databseUrl = System.getenv("DATABASE_URL");
		if(databseUrl == null) {
			url = properties.getUrl();
			username = properties.getUsername();
			password = properties.getPassword();
		} else {
			URI dbUri = new URI(databseUrl);
			url = "jdbc:log4jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
			username = dbUri.getUserInfo().split(":")[0];
			password = dbUri.getUserInfo().split(":")[1];
		}

		return DataSourceBuilder.create(this.properties.getClassLoader())
			.url(url)
			.username(username)
			.password(password)
			.build();
	}

}
