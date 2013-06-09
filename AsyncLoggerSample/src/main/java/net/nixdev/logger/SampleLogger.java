package net.nixdev.logger;

import net.nixdev.logger.AsyncLogger;

/**
 * Created by Pavel_Vinogradov on 6/9/13.
 */
public class SampleLogger implements AsyncLogger {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
