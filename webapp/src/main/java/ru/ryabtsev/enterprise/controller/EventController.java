package ru.ryabtsev.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.AsyncEvent;

import java.util.logging.Logger;

@Named
@RequestScoped
@URLMapping(
        id="event",
        pattern="/event",
        viewId="/WEB-INF/faces/event.xhtml"
)
public class EventController {
    private static final Logger LOGGER = Logger.getLogger(EventController.class.getSimpleName());

    @Inject
    private Event<AsyncEvent> asyncEvent;

    @Inject
    private Event<AsyncEvent> syncEvent;

    @Inject
    private JMSContext context;

//    @Resource(lookup = "java:/queue/simple-queue")
//    private Queue queue;
//
//    @Resource(lookup = "java:/topic/simple-topic")
//    private Topic topic;
}
