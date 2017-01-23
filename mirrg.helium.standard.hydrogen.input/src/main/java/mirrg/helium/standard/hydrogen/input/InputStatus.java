package mirrg.helium.standard.hydrogen.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class InputStatus implements IInputStatus
{

	private int x;
	private int y;
	private int w;
	private int px;
	private int py;
	private int pw;

	private Button[] buttons;
	private Button[] keys;

	public InputStatus()
	{
		this(8, 1024);
	}

	public InputStatus(int buttonsCount, int keysCount)
	{
		buttons = new Button[buttonsCount];
		keys = new Button[keysCount];
	}

	@Override
	public int getX()
	{
		return x;
	}

	@Override
	public int getY()
	{
		return y;
	}

	@Override
	public int getW()
	{
		return w;
	}

	@Override
	public int getPX()
	{
		return px;
	}

	@Override
	public int getPY()
	{
		return py;
	}

	@Override
	public int getPW()
	{
		return pw;
	}

	@Override
	public Button getButton(int index)
	{
		return buttons[index];
	}

	@Override
	public Button getKey(int index)
	{
		return keys[index];
	}

	@Override
	public int getButtonCount()
	{
		return buttons.length;
	}

	@Override
	public int getKeyCount()
	{
		return keys.length;
	}

	public synchronized void update()
	{
		px = x;
		py = y;
		pw = w;

		for (Button button : buttons) {
			button.update();
		}
		for (Button key : buttons) {
			key.update();
		}
	}

	public void mousePressed(MouseEvent event)
	{
		mousePressed(event.getX(), event.getY(), event.getButton());
	}

	public synchronized void mousePressed(int x, int y, int button)
	{
		this.x = x;
		this.y = y;
		buttons[button].press();
	}

	public synchronized void mousePressed(int button)
	{
		buttons[button].press();
	}

	public void mouseReleased(MouseEvent event)
	{
		mouseReleased(event.getX(), event.getY(), event.getButton());
	}

	public synchronized void mouseReleased(int x, int y, int button)
	{
		this.x = x;
		this.y = y;
		buttons[button].release();
	}

	public synchronized void mouseReleased(int button)
	{
		buttons[button].release();
	}

	public void mouseDragged(MouseEvent event)
	{
		mouseDragged(event.getX(), event.getY());
	}

	public synchronized void mouseDragged(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void mouseMoved(MouseEvent event)
	{
		mouseMoved(event.getX(), event.getY());
	}

	public synchronized void mouseMoved(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void mouseWheelMoved(MouseWheelEvent event)
	{
		mouseWheelMoved(event.getWheelRotation());
	}

	public synchronized void mouseWheelMoved(int wheelRotation)
	{
		w += wheelRotation;
	}

	public void keyPressed(KeyEvent event)
	{
		keyPressed(event.getKeyCode());
	}

	public synchronized void keyPressed(int keyCode)
	{
		keys[keyCode].press();
	}

	public void keyReleased(KeyEvent event)
	{
		keyReleased(event.getKeyCode());
	}

	public synchronized void keyReleased(int keyCode)
	{
		keys[keyCode].release();
	}

}
