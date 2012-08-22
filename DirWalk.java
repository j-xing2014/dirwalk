import java.io.*;

  
public class DirWalk {

	public static int dirwalk(String path)
	{
		String[] dirlist = (new File(path)).list();
		int total = 0;

		if (dirlist == null) {
			return 0;
		} 
		for (int i=0; i < dirlist.length; i++) {
			String filename = dirlist[i];
			if (filename.equals(".") || filename.equals("..")) {
				continue;
			}
			String fullpath=path + "/" + filename;
			File newfile = new File(fullpath);
			if (newfile.isDirectory()) {
				total += dirwalk(fullpath);
			}
			else {
				total++;
			}
		}
		return total;
	}


	public static void main(String args[])
	{
		int total;
		String dirname = args[0];
  
		System.out.println("Java Traversing: " + args[0]);
		total = dirwalk(args[0]);
		System.out.println("Java Total Files: " +  total);
	}
  
}
