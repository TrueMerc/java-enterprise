package ru.ryabtsev.enterprise.listener;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.servlet.AsyncEvent;
import java.util.logging.Logger;

/**
 * Implements synchronous events based logger.
 */
@Stateless
public class AsyncListener {
    private static final Logger LOGGER = Logger.getLogger(AsyncListener.class.getSimpleName());

    @Asynchronous
    public void observe(@Observes final AsyncEvent event) {
        LOGGER.info( "[ASYNC] OBSERVE  THREAD ID" + Thread.currentThread().getId() + ", event" + event);
    }
}
