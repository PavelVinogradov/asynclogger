/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nixdev.logger.client;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.nixdev.logger.AsyncLogger;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
import org.perf4j.javalog.JavaLogStopWatch;
import org.perf4j.log4j.Log4JStopWatch;

/**
 *
 * @author Pavel_Vinogradov
 */
public class LogGenerator {

    private AsyncLogger logger;
    private Integer threadsCount;
    private Integer messagesCount;
    private Integer messageSize;
    private ExecutorService executorService;
    private ExecutorCompletionService ecs;
    public LogGenerator(AsyncLogger logger, Integer threadsCount, Integer messagesCount, Integer messageSize) {
        this.logger = logger;
        this.threadsCount = threadsCount;
        this.messagesCount = messagesCount;
        this.messageSize = messageSize;
        
        executorService = Executors.newFixedThreadPool(threadsCount);
        ecs = new ExecutorCompletionService(executorService);
    } 
    
    public void run() {
        Object result = new Object();
        for (int i = 1; i <= threadsCount; i++) {
            ecs.submit(new LoggerThread(logger, messagesCount, messageSize), result);
        }
        
        try {
            for (int i = 1; i <= threadsCount; i++) {
                ecs.take();
            }
        
        //executorService.shutdown();
        
      
        //    executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(LogGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop() {
        executorService.shutdown();
    }
}

class LoggerThread implements Runnable {

    private AsyncLogger logger;
    private Integer messagesCount;
    private Integer messageSize;

    public LoggerThread(AsyncLogger logger, Integer messagesCount, Integer messageSize) {
        this.logger = logger;
        this.messagesCount = messagesCount;
        this.messageSize = messageSize;
    }
    
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String message = getMessage(messageSize);
        
        StopWatch stopWatch = new Log4JStopWatch(threadName);
        
        for (int i = 1; i <= messagesCount; i++) {
            //logger.logMessage("[" + threadName +"]: " + message + " " + i);
            logger.logMessage(message + " " + i);
        }
        
        stopWatch.stop();
    }
    
    public static String getMessage(Integer messageSize) {
        return "Hello";
    }
}
