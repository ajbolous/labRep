package Client;

import javax.swing.ImageIcon;

public class Resources {
	public static ImageIcon getIcon(String name){
		return new ImageIcon("img/" + name);
	}
}
