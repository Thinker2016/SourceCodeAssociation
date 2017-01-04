package exe;

import java.util.*;
import java.io.*;

public class Main {

	private static String BASEPATH = "./Java集合框架/";

	private void add(ListIterator<Integer> itr, int size) {
		for (int i = 0; i < size; i++) {
			itr.add(i + 1);
		}
	}

	public Map<Integer, LinkedHashMap<String, ArrayList<Integer>>> createDecade() {
		Map<Integer, LinkedHashMap<String, ArrayList<Integer>>> decade = new HashMap<>();
		for (int i = 2013; i < 2023; i++) {
			LinkedHashMap<String, ArrayList<Integer>> year = new LinkedHashMap<>();
			decade.put(i, year);// 对象的内容和对象的引用
			String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August",
					"September", "October", "November", "December" };
			for (int j = 0; j < 12; j++) {
				ArrayList<Integer> month = new ArrayList<>();
				year.put(monthName[j], month);
				ListIterator<Integer> mitr = month.listIterator();
				int size = 30;
				int k = j + 1;
				if (k == 1 || k == 3 || k == 5 || k == 7 || k == 8 || k == 10 || k == 12)
					size = 31;
				else if (k == 2) {
					if (i == 2016 || i == 2020) {
						size = 29;
					} else
						size = 28;
				}
				add(mitr, size);
			}
		}
		return decade;
	}

	public void outputCalender(Map<Integer, LinkedHashMap<String, ArrayList<Integer>>> decade, String filename) {
		File dir = new File(BASEPATH);
		if (!dir.exists())
			dir.mkdir();// 创建目录
		File file = new File(BASEPATH + filename);
		FileOutputStream output;
		try {
			output = new FileOutputStream(file);// 如果file本身不存在，这条语句会create一个File
			output.write("以下是2013年——2022年的日历：\n".getBytes());
			for (int i = 2013; i < 2023; i++) {
				output.write(new Integer(i).toString().getBytes());
				output.write("\n".getBytes());
				LinkedHashMap<String, ArrayList<Integer>> year = decade.get(i);
				Set<String> monthNameSet = year.keySet();
				for (String monthName : monthNameSet) {
					ArrayList<Integer> month = year.get(monthName);
					String str = "\t" + monthName + ":\n\t" + month.toString() + "\n";
					output.write(str.getBytes());
				}
			}
			output.flush();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<Integer, LinkedHashMap<String, ArrayList<Integer>>> createDecadeFromFile(File file) {
		HashMap<Integer, LinkedHashMap<String, ArrayList<Integer>>> decade = new HashMap<>();
		try {
			FileInputStream input = new FileInputStream(file);
			while (input.read() != '\n')
				;
			int[] b = new int[0x30];
			int i;
			for (int x = 0; x < 10; x++) {
				i = 0;
				try {
					while ((b[i] = input.read()) != '\n') // 此处待验证
						i++;
				} catch (IndexOutOfBoundsException ie) {
					System.err.println(i + "," + x);
					for (int n = 0; n < b.length; n++)
						System.err.print(b[n]);
					System.out.println();
				}
				int yearCode = 0;
				i--;
				for (int k = 1; i > -1; i--, k *= 10) {
					yearCode += (b[i] - '0') * k;
				}
				LinkedHashMap<String, ArrayList<Integer>> year = new LinkedHashMap<>();
				decade.put(yearCode, year);
				for (i = 0; i < 0xC; i++) {
					int j = 0;
					while ((b[j] = input.read()) != '\n')
						j++;
					byte[] monthNameByte = new byte[j - 2];
					for (int k = 0; k < j - 2; k++) {
						monthNameByte[k] = (byte) b[k + 1];
					}
					String monthNameStr = new String(monthNameByte);
					ArrayList<Integer> month = new ArrayList<>();
					year.put(monthNameStr, month);
					ListIterator<Integer> monthItr = month.listIterator();
					for (j = 0; j < 2; j++)
						input.read();
					int c, end = ']';
					boolean monthInfinish = true;
					while (monthInfinish) {
						int day = 0;
						while ((c = input.read()) != ',' && c != end) {
							day = day * 10 + c - '0';
						}
						if (c == end)
							monthInfinish = false;
						else
							input.read();
						monthItr.add(day);
					}
					input.read();
				}
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decade;
	}

	public Main() throws IOException {
		String[] filenames = { "日历_01", "日历_02" };
		outputCalender(createDecade(), filenames[0]);
		Map<Integer, LinkedHashMap<String, ArrayList<Integer>>> decade = createDecadeFromFile(
				new File(BASEPATH + filenames[0]));
		outputCalender(decade, filenames[1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Runtime.getRuntime().maxMemory());
	}

}
