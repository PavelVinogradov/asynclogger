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

    public static AsyncLogger getLogger() {
        return new SampleLogger();
    }
}
