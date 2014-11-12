package auth;

import java.util.Properties;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class ConfigBuilder {
	private static Configuration config;
	private static Properties propAuth = new Properties();
	private static final String API_KEY = "6zBCmalYnOe2cduu2RjRe4SSE";
	private static final String API_SECRET = "qRegDTlDIJIVJgCXzBibso9DE2r1BWdORgLzv8POChyN5xIt8G";
	private static final String ACCESS_TOKEN = "35180303-uTRGqpSUBcj5jHk7P1UmBQKDlC1AwewUKRknO6X0d";
	private static final String ACCESS_SECRET = "prEPqqn106voTkCC3sBVoNPfyTugG5bJd4mqcoR0hhJVv";
	
	static {
		
		//propAuth.load(inStream);
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(API_KEY);
		cb.setOAuthConsumerSecret(API_SECRET);
		cb.setOAuthAccessToken(ACCESS_TOKEN);
		cb.setOAuthAccessTokenSecret(ACCESS_SECRET);
		cb.setJSONStoreEnabled(true);
		config = cb.build();
	}
	
	public static Configuration getConfig() {
		return config;
	}
}
