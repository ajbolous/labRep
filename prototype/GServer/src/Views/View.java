package Views;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class View {
	public Object resolve(String view, String[] params) {
		try {
			Method method = this.getClass().getMethod(view, params.getClass());
			return method.invoke(this, new Object[] { params });
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			return null;
		}
	}
}
