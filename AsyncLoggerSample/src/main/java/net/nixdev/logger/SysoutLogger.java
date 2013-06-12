package net.nixdev.logger;

/**
 * Created by Pavel_Vinogradov on 6/9/13.
 */
public class SysoutLogger extends BaseLogger {
    
    public SysoutLogger(String srcHost, String product) {
        super(srcHost, product);
    }
     
    @Override
    public void logMessage(String message) {
        System.out.println("[" + host + "][" + product + "] " + message);
    }
}
