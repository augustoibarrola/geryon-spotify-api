package com.ger.utility;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import se.michaelthelin.spotify.model_objects.specification.Album;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Component
@Aspect
public class LoggingAspect {

    public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    public void logServiceException(Exception exception) throws Exception {
        LOGGER.error(exception.getMessage(), exception);
    }

    @Before("execution(* com.ger.api.*.getAlbumById(..)) && args(albumId,..)")
    public void beforeGetAlbumById(String albumId) throws Exception {
        LOGGER.info("Getting Album by its Spotify ID " + albumId);
    }

    @After("execution(* com.ger.api.*.getAlbumById(..)) && args(albumId,..)")
    public void afterGetAlbumById(String albumId) throws Exception {

        LOGGER.info("Got Album with Spotify ID " + albumId);


    }
    
    @AfterReturning(pointcut="execution(* com.ger.api.*.getAlbumById(..))", returning="album")
    public void afterReturningGetAlbumById(Album album) throws Exception {

        LOGGER.info("Album is :" + album.getName());

    }

}
