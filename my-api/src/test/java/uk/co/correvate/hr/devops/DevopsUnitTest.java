package uk.co.correvate.hr.devops;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertNotEquals;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * Some dummy unit tests. Ensuring version is updated according to assignment requirements.
 */
@SpringBootTest
public class DevopsUnitTest {

  @ClassRule
  public static final SpringClassRule springClassRule = new SpringClassRule();

  @Rule
  public final SpringMethodRule springMethodRule = new SpringMethodRule();

  @Autowired
  BuildProperties buildProperties;

  @Test
  public void oldVersionTest() {
    var oldVersion = "1.0.0.1591234567";
    assertNotEquals(oldVersion, buildProperties.getVersion());
  }

  @Test
  public void versionFormatTest() {
    var expectedVersionPrefix = "1.0.1.";
    var currentVersion = buildProperties.getVersion();
    assertThat(currentVersion, startsWith(expectedVersionPrefix));

    var oldVersionEpoch = 1591234567l;
    var currentEpoch = Long.parseLong(currentVersion.substring(expectedVersionPrefix.length()));
    assertThat(currentEpoch, greaterThan(oldVersionEpoch));
  }
}
