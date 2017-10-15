package hu.test.dynamic.dynamictables;

import hu.test.dynamic.dynamictables.domain2.Event;
import hu.test.dynamic.dynamictables.domain.EventType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamictablesApplicationTests {


	@Autowired
	private EventTypeService eventTypeService;

	@Test
	public void saveEventType() {
        EventType eventType = EventType.builder()
                .name("ANY_NAME")
                .description("ANY_DESCRIPTION")
                .build();

        eventTypeService.saveEventType(eventType);
	}

	@Test
    public void saveEvent() {
        Event event = Event.builder()
                .name("ANY_EVENT_NAME")
                .build();

        eventTypeService.saveEvent(event);
    }

}
