package buildArffFile;

import java.util.*;
import java.io.*;

public class WriteToArffFile {

	private Map<File, ArrayList<Boolean>> map;
	private Set<String> attributeSet;
	private File target;
	private BufferedWriter bw;
	private StringBuffer stringBuffer;

	public void write() {
		buildHead();
		buildBody();
		try {
			bw = new BufferedWriter(new FileWriter(target));
			bw.write(stringBuffer.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buildHead() {
		String values = "{t}";
		stringBuffer.append("@relation SourceCodeAssociation\n");
		for (String attributeName : attributeSet) {
			stringBuffer.append("@attribute '" + attributeName + "' " + values + "\n");
		}
	}

	public void buildBody() {
		stringBuffer.append("@data\n");
		for (File file : map.keySet()) {
			ArrayList<Boolean> attributes = map.get(file);
			// for (Boolean value : attributes) {
			// // stringBuffer.append(value + ",");
			// stringBuffer.append((value ? "t" : "?") + ",");
			// }
			ListIterator<Boolean> itr = attributes.listIterator();
			while (itr.hasNext()) {
				Boolean value = itr.next();
				stringBuffer.append((value ? "t" : "?") + (itr.hasNext() ? "," : ""));
			}

			stringBuffer.append('\n');
		}
	}

	public WriteToArffFile(Map<File, ArrayList<Boolean>> map, Set<String> attributeSet, File target) {
		this.map = map;
		this.attributeSet = attributeSet;
		this.target = target;
		stringBuffer = new StringBuffer();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<File> fileList = new FindAllJavaFiles(args[0]).getFileList();
		Set<String> attributeSet = new FindAllAttributes(fileList).getAttributeSet();
		Map<File, ArrayList<Boolean>> map = new FindOccurrence(fileList, attributeSet).getMap();
		File target = new File("sourceCodeAssociation.arff");
		new WriteToArffFile(map, attributeSet, target).write();

	}

}
