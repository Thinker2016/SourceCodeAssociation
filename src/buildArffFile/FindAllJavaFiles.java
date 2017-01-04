package buildArffFile;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FindAllJavaFiles {

	private ArrayList<File> fileList;
	private Pattern pattern;

	public void findFiles(File dir) {
		if (!dir.isDirectory())
			return;
		File[] files = dir.listFiles((path, name) -> {
			return pattern.matcher(name).matches();
		});
		File[] dirs = dir.listFiles((file) -> {
			return file.isDirectory();
		});
		Collections.addAll(fileList, files);
		for (File elem : dirs) {
			findFiles(elem);
		}
	}

	public List<File> getFileList() {
		return fileList;
	}

	public FindAllJavaFiles(String pathStr) {
		File path = new File(pathStr);
		// File path = new File("/home/wenzhao/SoftwareFactory/java/Jama");
		fileList = new ArrayList<>();
		pattern = Pattern.compile(".*[.]java");
		findFiles(path);
		fileList.sort((file1, file2) -> file1.compareTo(file2));
		/*for (File elem : fileList) {
			System.out.println(elem.getName());
		}*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FindAllJavaFiles(args[0]);
	}

}
