import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFileChooser;



public class ShapesLoader {
//	private static ShapesLoader shapesLoader;
	
	public ShapesLoader(){
		
	}
	public Class loadClass(){
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
		return cls;
	}
//	public Class[] getValiableShapes(){
//		
//		if (shapesLoader ==null){
//			shapesLoader = new ShapesLoader();
//		}
//		return null;
//		
//	}
}
