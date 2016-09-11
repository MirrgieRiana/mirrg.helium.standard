package mirrg.helium.standard.hydrogen.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class HLambda
{

	public static <T> T process(T object, Consumer<T> consumer)
	{
		consumer.accept(object);
		return object;
	}

	public static <T> T get(Supplier<T> supplier)
	{
		return supplier.get();
	}

	/**
	 * 添え字番号付きfor
	 */
	public static <T> void forEach(Stream<T> stream, ObjIntConsumer<T> consumer)
	{
		Integer[] i = new Integer[] {
			0,
		};
		stream.sequential().forEach(object -> {
			consumer.accept(object, i[0]);
			i[0]++;
		});
	}

	public static <T> Stream<T> toStream(Enumeration<T> e)
	{
		return StreamSupport.stream(
			Spliterators.spliteratorUnknownSize(
				new Iterator<T>() {

					@Override
					public T next()
					{
						return e.nextElement();
					}

					@Override
					public boolean hasNext()
					{
						return e.hasMoreElements();
					}

				},
				Spliterator.ORDERED), false);
	}

}
