package com.awander.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

/**
 * File工具类
 * @author zhy
 *
 */
public class FileUtils {
	
	/**
	 * 枚举目录下的所有文件
	 * @param dir
	 * @param arrFiles
	 */
	public static void listFiles(File dir, ArrayList<File> arrFiles)throws IOException, FileSystemLoopException{
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录:" + dir + "不存在！");
		}
		
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录！");
		}
		
		File[] files = dir.listFiles();
		if (files == null || files.length < 1) {
			return;
		}
		
		for (File file : files) {
			if (!file.exists()) {
				continue;
			}
			if (file.isFile()) {
				arrFiles.add(file);
			}
			else{
				listFiles(file,arrFiles);
			}
		}
	}
}
