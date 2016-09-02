package mirrg.helium.standard.hydrogen.event;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * とてもシンプルなイベントマネージャです。
 */
public class EventManager<T>
{

	private ArrayList<Class<? extends T>> classes = new ArrayList<>();
	private ArrayList<Predicate<? extends T>> handlers = new ArrayList<>();

	/**
	 * 登録した順番に呼び出されます。
	 */
	public <E extends T> void register(Class<E> clazz, Consumer<E> handler)
	{
		registerRemovable(clazz, e -> {
			handler.accept(e);
			return true;
		});
	}

	/**
	 * 登録した順番に呼び出されます。
	 *
	 * @param handler
	 *            falseを返した場合、このイベントハンドラは無効となります。
	 */
	public <E extends T> void registerRemovable(Class<E> clazz, Predicate<E> handler)
	{
		classes.add(clazz);
		handlers.add(handler);
	}

	/**
	 * 登録時のクラスがこのイベントと代入互換であるハンドラを、
	 * 登録時の順番に起動します。
	 */
	@SuppressWarnings("unchecked")
	public <E extends T> void post(E event)
	{
		for (int i = 0; i < classes.size(); i++) {
			if (classes.get(i).isInstance(event)) {

				if (!((Predicate<E>) handlers.get(i)).test(event)) {
					classes.remove(i);
					handlers.remove(i);
					i--;
				}

			}
		}
	}

}
