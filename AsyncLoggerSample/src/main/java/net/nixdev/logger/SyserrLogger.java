package net.nixdev.logger;

/**
 * Created by Pavel_Vinogradov on 6/9/13.
 */
public class SyserrLogger extends BaseLogger{
    
    public SyserrLogger(String srcHost, String product) {
        super(srcHost, product);
    }
       
    @Override
    public void logMessage(String message) {
        System.err.println("[" + host + "][" + product + "] " + message);
    }
}
