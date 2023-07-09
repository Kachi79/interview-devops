package uk.co.correvate.hr.devops;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DevopsTestApp extends SpringBootServletInitializer {

  private static final Logger LOG = LoggerFactory.getLogger(DevopsTestApp.class);

  @Autowired
  BuildProperties buildProperties;

  public static void main(String[] args) {
    SpringApplication.run(DevopsTestApp.class, args);
  }

  @PostConstruct
  public void onStartup() {
    // logging something...
    LOG.info("Starting awesome application {}:{}:{} ...",
        buildProperties.getGroup(),
        buildProperties.getArtifact(), buildProperties.getVersion());
  }
}
