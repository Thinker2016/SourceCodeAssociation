package buildArffFile;

import java.io.*;
import java.util.*;

public class FindAllAttributes {

	private TreeSet<String> attributeSet;
	private List<File> fileList;

	public FindAllAttributes(List<File> fileList) {
		this.fileList = fileList;
		attributeSet = new TreeSet<>();
		findAttributes();
	}

	public void findAttributes() {
		for (File file : fileList)
			findAttributesOfClass(file);
	}

	public void findAttributesOfClass(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			String[] keywords = { "import", "package", "public", "private", "double", "void", "int", "long", "String",
					"return", "java", "util", "io", "class", "new", "method", "Auto", "TODO", "Override", "static",
					"main", "extends", "implements", "stub", "generated", "Jama", "args", "i", "j", "k", "s", "str" };
			Set<String> set = new HashSet<>();
			set.addAll(Arrays.asList(keywords));
			while ((line = br.readLine()) != null) {
				String[] words = line.split("[\\s\\p{Punct}]+");
				// attributeSet.addAll(Arrays.asList(words));
				List<String> wordList = Arrays.asList(words);
				for (String elem : wordList)
					if (elem.length() > 1 && elem.charAt(0) > '9' && !set.contains(elem))
						attributeSet.add(elem);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<File> getFileList() {
		return fileList;
	}

	public Set<String> getAttributeSet() {
		return attributeSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FindAllAttributes(new FindAllJavaFiles(args[0]).getFileList()).getAttributeSet().size());
	}

}
