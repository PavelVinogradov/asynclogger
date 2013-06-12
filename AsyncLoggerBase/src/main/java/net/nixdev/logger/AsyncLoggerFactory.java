/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nixdev.logger;

/**
 *
 * @author Pavel_Vinogradov
 */
public class AsyncLoggerFactory {

    public static AsyncLogger getLogger(LoggerType logType, String srcHost, String product) {
        AsyncLogger logger;
        
        switch (logType) {
            case SYSERR:
                logger = new SyserrLogger(srcHost, product);
                break;
                
            case LOGBACK:
                logger = new LogbackLogger(srcHost, product);
                break;
                
            case SYSOUT:
            default: 
                logger = new SyserrLogger(srcHost, product);
        }
        
        return logger;
    }
}
