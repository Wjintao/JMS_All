package activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import activemq.publisher.MessageSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "../spring/application-jms.xml"})
public class TestSenderService {

	@Autowired
	private MessageSender messageSender;

	@Test
	public void run() {
		messageSender.send("message");
	}

}
