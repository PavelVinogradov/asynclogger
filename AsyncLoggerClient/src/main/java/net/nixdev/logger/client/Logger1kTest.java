/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nixdev.logger.client;

import net.nixdev.logger.AsyncLogger;
import net.nixdev.logger.AsyncLoggerFactory;
import net.nixdev.logger.SampleLogger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

/**
 *
 * @author Pavel_Vinogradov
 */
public class Logger1kTest {
    
    public static void main(String[] argv) {
        StopWatch stopWatch = new LoggingStopWatch("Logger100kTest");
        AsyncLogger logger = AsyncLoggerFactory.getLogger();
        
        for (int i = 0; i <= 1000; i++) {
            logger.logMessage("Hello: " + i);
        }
        
        stopWatch.stop("Logger100kTest", "Test finished");
    }
}
