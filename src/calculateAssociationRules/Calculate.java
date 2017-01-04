package calculateAssociationRules;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import buildArffFile.*;
import weka.associations.*;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathStr = args[0];
		String[] associatorArgs = new String[args.length - 1];
		for (int i = 1; i < args.length; i++)
			associatorArgs[i - 1] = args[i];
		List<File> fileList = new FindAllJavaFiles(pathStr).getFileList();
		Set<String> attributeSet = new FindAllAttributes(fileList).getAttributeSet();
		Map<File, ArrayList<Boolean>> map = new FindOccurrence(fileList, attributeSet).getMap();
		File target = new File("sourceCodeAssociation.arff");
		new WriteToArffFile(map, attributeSet, target).write();
		AbstractAssociator.runAssociator(new FPGrowth(), associatorArgs);
	}

}
