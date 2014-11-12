package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.FilterQuery;
import twitter4j.RateLimitStatusEvent;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import auth.ConfigBuilder;


public class Driver {
	
	private static final transient Logger LOG = LoggerFactory.getLogger(Driver.class);
	private FilterQuery filter = new FilterQuery();
    private String[] keywordsArray = {"Hobbit","avenger"};
    
	public static void main(String[] args)
	{
		Driver dr = new Driver();
		dr.filter.track(dr.keywordsArray);
		LOG.info("Initializing...");
		LOG.debug("Creating Listener...");
		EnglishStatusListener listener = new EnglishStatusListener();
		LOG.debug("Creating Stream...");
	    TwitterStream twitterStream = new TwitterStreamFactory(ConfigBuilder.getConfig()).getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.filter(dr.filter);
	    
	    
	       
	  
	    LOG.info("Initialization Complete.");
	   // twitterStream.sample();
	}

}
