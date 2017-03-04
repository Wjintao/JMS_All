package activemq.publisher;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

import activemq.ScheduleMessagePostProcessor;

public class MessageSender {

	private final JmsTemplate jmsTemplate;
	private final Destination destination;

	public MessageSender(final JmsTemplate jmsTemplate, final Destination destination) {
		this.jmsTemplate = jmsTemplate;
		this.destination = destination;
	}

	public void send(final Object text) {
		try {
			jmsTemplate.setDefaultDestination(destination);
			jmsTemplate.convertAndSend(text,new ScheduleMessagePostProcessor(30 * 1000));
			System.out.println("发送消息 : " + text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
