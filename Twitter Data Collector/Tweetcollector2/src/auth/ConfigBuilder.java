package auth;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class ConfigBuilder
{
  private static Configuration config;
  private static Properties propAuth = new Properties();
  public static InputStream input = null;
  
  static
  {
    try
    {
      input = new FileInputStream("config.properties");
      propAuth.load(input);
      ConfigurationBuilder cb = new ConfigurationBuilder();
      cb.setDebugEnabled(true);
      cb.setOAuthConsumerKey(propAuth.getProperty("API_KEY"));
      cb.setOAuthConsumerSecret(propAuth.getProperty("API_SECRET"));
      cb.setOAuthAccessToken(propAuth.getProperty("ACCESS_TOKEN"));
      cb.setOAuthAccessTokenSecret(propAuth.getProperty("ACCESS_SECRET"));
      cb.setJSONStoreEnabled(true);
      config = cb.build();
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
  }
  
  public static Configuration getConfig()
  {
    return config;
  }
}
