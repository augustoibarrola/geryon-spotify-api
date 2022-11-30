package com.ger.utility;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Aspect
public class LoggingAspect {
    
    public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
    
    public void logServiceException(Exception exception) throws Exception{
        LOGGER.error(exception.getMessage(), exception);
    }
    
    @Before("execution(* com.ger.api.*.getArtist*(..))")
    public void beforeGetAlbumById() throws Exception {
        System.out.println("\nGetting artist and their albums for ya...\n");
    }
    
    @Before("execution(* com.ger.api.*.getAlbum*(..))")
    public void afterAdvice() throws Exception {
        System.out.println("\nGetting that album...\n");
    }

}
