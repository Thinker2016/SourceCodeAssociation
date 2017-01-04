package buildArffFile;

import java.util.*;
import java.io.*;

public class FindOccurrence {

	private LinkedHashMap<File, ArrayList<Boolean>> map;
	private Set<String> attributeSet;
	private List<File> fileList;

	public void buildMap() {
		for (File file : fileList) {
			ArrayList<Boolean> attributeOccurrenceList = new ArrayList<>();
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				HashSet<String> localSet = new HashSet<>();
				String line;
				while ((line = br.readLine()) != null) {
					String[] words = line.split("[\\s\\p{Punct}]+");
					localSet.addAll(Arrays.asList(words));
				}
				br.close();
				for (String elem : attributeSet) {
					if (localSet.contains(elem)) {
						attributeOccurrenceList.add(true);
					} else {
						attributeOccurrenceList.add(false);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			map.put(file, attributeOccurrenceList);
		}
	}

	public FindOccurrence(List<File> fileList, Set<String> attributeSet) {
		this.attributeSet = attributeSet;
		this.fileList = fileList;
		map = new LinkedHashMap<>();
		buildMap();
	}

	public Map<File, ArrayList<Boolean>> getMap() {
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<File> fileList = new FindAllJavaFiles(args[0]).getFileList();
		Set<String> attributeSet = new FindAllAttributes(fileList).getAttributeSet();
		System.out.println(new FindOccurrence(fileList, attributeSet).getMap());
	}

}
