package Views;

import java.sql.SQLException;

public abstract class View {
	public View() {
	}

	public abstract Object resolve(String view, String[] params);
}
