package test;

import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import random.CreateRandomList;
import sorts.AbstractSort;;

public class Exe {

	@Test
	public void good() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("请输入测试所用的数据的条数的取10对数（2表示100条，7表示1千万条，只支持正整数对数，默认取7）：");
		int size = 10000000;
		if (s.hasNextLine()) {
			String sizeStr = s.nextLine().trim();
			if (sizeStr.length() != 0) {
				int i = Integer.parseInt(sizeStr);
				for (size = 1; i > 0; i--)
					size *= 10;
			}
		}
		long begin = System.currentTimeMillis();
		ArrayList<Integer> list = CreateRandomList.createList(size);
		long end = System.currentTimeMillis();
		System.out.println("生成list用时" + (end - begin) + "毫秒");
		try {
			OutputStream output = new FileOutputStream("randomList");
			try {
				output.write(list.toString().getBytes());
				output.flush();
				output.close();
				System.out.println("已将随机数列表输出至randomList文件当中");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请输入要使用的排序类的简名（默认为QuickSort）：");
		if (s.hasNextLine()) {
			String name = s.nextLine().trim();
			if (name.length() == 0)
				name = "QuickSort";
			// int n = 5;
			// int max = n / 0;
			// name = Exe.class.getPackage().getName() + "." + name;
			name = "sorts." + name;
			try {
				@SuppressWarnings("unchecked")
				Class c = Class.forName(name);
				Constructor<AbstractSort<Integer>> ct;
				try {
					ct = c.getConstructor(ArrayList.class);
					AbstractSort<Integer> sort = ct.newInstance(list);
					begin = System.currentTimeMillis();
					sort.sort();
					end = System.currentTimeMillis();
					System.out.println("排序用时" + (end - begin) + "毫秒");
					if (size <= 100) {
						System.out.println("排序完成后的元素列表为" + list);
					} else {
						System.out.println("排序完成后的前十个元素为" + list.subList(0, 10));
						System.out.println("排序完成后的后十个元素为" + list.subList(size - 10, size));
						System.out.println("列表的大小为" + list.size());
					}
					try {
						OutputStream output = new FileOutputStream("output");
						try {
							output.write(list.toString().getBytes());
							output.flush();
							output.close();
							System.out.println("已将排序完成后的列表输出至output文件当中");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException | SecurityException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
