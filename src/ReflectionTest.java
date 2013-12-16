
import java.awt.Color;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class ReflectionTest {
	public static void main(String[] args) {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		String className = fileChooser.getSelectedFile().getName();
		String path=fileChooser.getSelectedFile().getAbsolutePath();
		path=path.replace(className, "");
		className=className.replace(".class", "");
		String abc = className;
		Class cls = null;
		try {
			File file = new File(path);
			// convert the file to URL format
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };
			// load this folder into Class loader
			ClassLoader cl = new URLClassLoader(urls);
			cls = cl.loadClass(abc);
			// System.out.println("cls.getName() = " + cls.getName());

			// cls.encrypt();

		} catch (ClassNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		}

		ArrayList<Class> arr1 = new ArrayList<>();
		ArrayList<Shape> arr2 = new ArrayList<>();
		Class t1 = Shape1.class;
		Class t2 = Shape2.class;
		// System.out.println(t2.getName());
		// Class[] t3=t2.getDeclaredClasses();
		// System.out.println(t3);
		arr1.add(t1);
		arr1.add(t2);
		arr1.add(cls);
		for (int i = 0; i < arr1.size(); i++) {
			try {
				Object o = arr1.get(i).getConstructor(Color.class, int.class, int.class, int.class, int.class).newInstance(Color.black,1,2,3,4);
				arr2.add((Shape) o);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < arr2.size(); i++) {
			System.out.println(arr2.get(i));
		}
//		System.out.println(arr2.get(2).getPostionX());
//		System.out.println(arr2.get(2).getClass().getName());


	}
}
