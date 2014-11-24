package code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;

public class EnglishStatusListener
  implements StatusListener
{
  private static final transient Logger LOG = LoggerFactory.getLogger(EnglishStatusListener.class);
  
  public void onException(Exception arg0) {
	  
	  
  }
  
  public void onDeletionNotice(StatusDeletionNotice arg0) {}
  
  public void onScrubGeo(long arg0, long arg1) {}
  
  public void onStallWarning(StallWarning arg0) {}
  
  public void onStatus(Status status)
  {
    String tweetText = status.getText();
    String delimiter = "\t";
    if (isEnglish(tweetText))
    {
    	StringBuffer statusBuf = new StringBuffer(); //String buffer for efficient concatenation of String
     // String rawJSON = TwitterObjectFactory.getRawJSON(status); //in case we need the whole data in JSON format
     // LOG.info(rawJSON + "\n");
    	statusBuf.append(status.getId()).append(delimiter).append(status.getText().replace("/n"," ")); //update added replace function to handle new line chars 																															
    	LOG.info(statusBuf.toString());
    }
  }
  
  public void onTrackLimitationNotice(int arg0) {}
  
  public static boolean isEnglish(String tweetText)
  {
    for (int i = 0; i < tweetText.length(); i++)
    {
      int c = tweetText.charAt(i);
      if (c > 127) {
        return false;
      }
    }
    return true;
  }
}
