package net.nixdev.logger.client;

import net.nixdev.logger.AsyncLogger;
import net.nixdev.logger.SampleLogger;

/**
 * Created by Pavel_Vinogradov on 6/9/13.
 */
public class SampleLoggerClient {

    public static void main(String argv[])  {
        AsyncLogger logger = new SampleLogger();

        logger.logMessage("Hello");
    }

}
