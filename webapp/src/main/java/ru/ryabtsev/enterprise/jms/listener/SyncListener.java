package ru.ryabtsev.enterprise.jms.listener;

import javax.enterprise.event.Observes;
import javax.servlet.AsyncEvent;
import java.util.logging.Logger;

/**
 * Implements synchronous events based logger.
 */
public class SyncListener {
    private static final Logger LOGGER = Logger.getLogger(AsyncListener.class.getSimpleName());


    public void observe(@Observes final AsyncEvent event) {
        LOGGER.info( "[SYNC] OBSERVE  THREAD ID" + Thread.currentThread().getId() + ", event" + event);
    }
}
