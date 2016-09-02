package mirrg.helium.standard.hydrogen.event;

import static org.junit.Assert.*;

import java.util.function.Predicate;

import org.junit.Test;

public class TestEventManager
{

	@Test
	public void test()
	{
		String[] message = {
			"",
		};

		EventManager<Integer> eventManager = new EventManager<>();
		eventManager.register(Integer.class, event -> {
			message[0] += event;
		});

		eventManager.post(Integer.valueOf(4));
		assertEquals("4", message[0]);
	}

	@Test
	public void test2()
	{
		String[] message = {
			"",
		};

		EventManager<Object> eventManager = new EventManager<>();
		eventManager.register(Integer.class, event -> {
			message[0] += event;
		});
		eventManager.register(String.class, event -> {
			message[0] += event;
		});

		eventManager.post(Integer.valueOf(4));
		assertEquals("4", message[0]);

		eventManager.post("G");
		assertEquals("4G", message[0]);

	}

	@Test
	public void test3()
	{
		String[] message = {
			"",
		};

		EventManager<Object> eventManager = new EventManager<>();
		eventManager.register(Integer.class, event -> {
			message[0] += "I";
		});
		eventManager.register(String.class, event -> {
			message[0] += "S";
		});
		eventManager.register(Double.class, event -> {
			message[0] += "D";
		});
		eventManager.register(Number.class, event -> {
			message[0] += "N";
		});

		eventManager.post(Integer.valueOf(4));
		assertEquals("IN", message[0]);

		eventManager.post("G");
		assertEquals("INS", message[0]);

		eventManager.post((Object) Integer.valueOf(4));
		assertEquals("INSIN", message[0]);

		eventManager.post(Double.valueOf(4));
		assertEquals("INSINDN", message[0]);

	}

	@Test
	public void test4()
	{
		String[] message = {
			"",
		};

		EventManager<Object> eventManager = new EventManager<>();

		eventManager.post(new Object());
		assertEquals("", message[0]);

		eventManager.register(Object.class, event -> {
			message[0] += "A";
		});

		eventManager.post(new Object());
		assertEquals("A", message[0]);

		eventManager.registerRemovable(Object.class, event -> {
			message[0] += "B";
			return false;
		});

		eventManager.post(new Object());
		assertEquals("AAB", message[0]);

		eventManager.registerRemovable(Object.class, new Predicate<Object>() {

			private boolean first = true;

			@Override
			public boolean test(Object event)
			{
				message[0] += "C";

				if (first) {
					first = false;
					return true;
				} else {
					return false;
				}
			}

		});

		eventManager.post(new Object());
		assertEquals("AABAC", message[0]);

		eventManager.post(new Object());
		assertEquals("AABACAC", message[0]);

		eventManager.post(new Object());
		assertEquals("AABACACA", message[0]);

		eventManager.post(new Object());
		assertEquals("AABACACAA", message[0]);

	}

}
