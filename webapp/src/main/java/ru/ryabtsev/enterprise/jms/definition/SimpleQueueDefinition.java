package ru.ryabtsev.enterprise.jms.definition;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;

@Startup
@Singleton
@JMSDestinationDefinition(
        name="java:/queue/simple-queue",
        interfaceName = "java.jms.Queue",
        destinationName = "simple-queue"
)
public class SimpleQueueDefinition {
}
