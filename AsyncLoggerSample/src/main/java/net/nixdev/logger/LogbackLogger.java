package net.nixdev.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Pavel_Vinogradov on 6/9/13.
 */
public class LogbackLogger extends BaseLogger{
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public LogbackLogger(String srcHost, String product) {
        super(srcHost, product);
    }
    
    @Override
    public void logMessage(String message) {
        logger.debug("[" + host + "][" + product + "] " + message);
    }
}
