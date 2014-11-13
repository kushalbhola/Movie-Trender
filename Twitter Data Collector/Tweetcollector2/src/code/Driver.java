package code;

import auth.ConfigBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class Driver
{
  private static final transient Logger LOG = LoggerFactory.getLogger(Driver.class);
  private FilterQuery filter = new FilterQuery();
  Properties propKeyWord = new Properties();
  private String[] keywordsArray = null;
  
  public static void main(String[] args)
  {
    try
    {
      InputStream input = new FileInputStream("keywords.properties");
      
      Driver dr = new Driver();
      dr.propKeyWord.load(input);
      dr.keywordsArray = dr.propKeyWord.getProperty("Keywords").split(",");
      dr.filter.track(dr.keywordsArray);
      
      LOG.info("Initializing...");
      LOG.debug("Creating Listener...");
      EnglishStatusListener listener = new EnglishStatusListener();
      LOG.debug("Creating Stream...");
      TwitterStream twitterStream = new TwitterStreamFactory(ConfigBuilder.getConfig()).getInstance();
      
      twitterStream.addListener(listener);
      twitterStream.filter(dr.filter);
      



      LOG.info("Initialization Complete.");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
