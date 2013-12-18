import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.JFileChooser;



public class ShapesLoader {
	private static ShapesLoader shapesLoader;
	
	private ShapesLoader(){
		
	}
	public static ShapesLoader makeshapesLoader(){
		if (shapesLoader==null){
			shapesLoader=new ShapesLoader();
		}
		return shapesLoader;
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
	public static ArrayList<Class> loadClasses(){
		ArrayList<Class> arr=new ArrayList<>();
		 File dir = new File("D:\\Game Folder\\Shapes");
		  for (File child : dir.listFiles()) {
		    // Do something with child
//			  System.out.println("tttttttttttt"+file.getName());
//			  URL url;
//			try {
//				url = file.toURI().toURL();
//				URL[] urls = new URL[] { url };
//				ClassLoader cl = new URLClassLoader(urls);
//				String abc=file.getName().replace(".class", "");
//				System.out.println("mmmmmmmmmmmmmmmm"+abc);
//				Class cls = cl.loadClass(abc);
//				arr.add(cls);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			  JFileChooser fileChooser = new JFileChooser();
//				fileChooser.showOpenDialog(null);
				String className = child.getName();
				String path=child.getAbsolutePath();
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
				arr.add(cls);
		  }
		  System.out.println(arr);

		return arr;
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
