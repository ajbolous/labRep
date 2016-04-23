package Views;

public abstract class View {
	public View() {
	}

	public abstract Object resolve(String view, String[] params);
}
