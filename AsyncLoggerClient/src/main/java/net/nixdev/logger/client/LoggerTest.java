/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nixdev.logger.client;

import net.nixdev.logger.AsyncLogger;
import net.nixdev.logger.AsyncLoggerFactory;
import net.nixdev.logger.LoggerType;


/**
 *
 * @author Pavel_Vinogradov
 */
public class LoggerTest {
    
    public static void main(String[] argv) {       
        AsyncLogger logger = AsyncLoggerFactory.getLogger(LoggerType.LOGBACK, "localhost", "test");
        LogGenerator generator = new LogGenerator(logger, 10, 100, 100);
        
        for (int i = 1; i <= 50; i++) {    
            generator.run();
        }
        
        generator.stop();
    }
}
