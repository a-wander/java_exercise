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
 * File������
 * @author zhy
 *
 */
public class FileUtils {
	
	/**
	 * ö��Ŀ¼�µ������ļ�
	 * @param dir
	 * @param arrFiles
	 */
	public static void listFiles(File dir, ArrayList<File> arrFiles)throws IOException, FileSystemLoopException{
		if (!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼:" + dir + "�����ڣ�");
		}
		
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "����Ŀ¼��");
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
