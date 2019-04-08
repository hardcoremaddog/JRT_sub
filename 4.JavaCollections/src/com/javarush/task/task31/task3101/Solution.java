package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
	private List<File> lowerThan50bytes = new ArrayList<>();

	private void processFilesFromFolder(File folder) {
		for (File entry : folder.listFiles()) {
			if (entry.isDirectory()) {
				processFilesFromFolder(entry);
				continue;
			}
			if (entry.length() <= 50) {
				lowerThan50bytes.add(entry);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File path = new File(args[0]);
		File resultFileAbsolutePath = new File(args[1]);

		File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
		FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

		Solution solution = new Solution();
		solution.processFilesFromFolder(path);

		solution.lowerThan50bytes.sort(Comparator.comparing(File::getName));

		try (FileWriter fileWriter = new FileWriter(allFilesContent)) {
			for (File file : solution.lowerThan50bytes) {
				try (FileReader fileReader = new FileReader(file)) {
					int c;
					while ((c = fileReader.read()) != -1) {
						fileWriter.write(c);
					}
					fileWriter.write("\n");
				}
			}
		}
	}
}