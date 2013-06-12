/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nixdev.logger;

/**
 *
 * @author Pavel_Vinogradov
 */
public abstract class BaseLogger implements AsyncLogger {
    
    protected String host;
    protected String product;
    
    public BaseLogger(String srcHost, String product) {
        this.host = srcHost;
        this.product = product;
    }
}
