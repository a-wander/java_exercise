package com.zhy.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.awander.utils.FileUtils;

public class Test {

	public static void main(String[] args) {
		File file = new File("E:\\");
		ArrayList<File> arrFile = new ArrayList<File>();
		try {
			FileUtils.listFiles(file,arrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (File file2 : arrFile) {
			System.out.println(file2.getAbsolutePath());
		}
		
		File[] roots = File.listRoots();
		if (roots != null) {
			for (File file2 : roots) {
				System.out.println(file2.getAbsolutePath());
			}
		}
	}

}
