package org.kniit.lab11.task25;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileProcessor {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;
    private final FileDAO fileDAO = new FileDAO();

    public void processFiles(String path) {
        File root = new File(path);

        if (!root.exists()) {
            System.out.println("Ошибка: Путь не существует.");
            return;
        }

        if (root.isFile()) {
            processSingleFile(root);
        } else if (root.isDirectory()) {
            processDirectory(root);
        }
    }

    private void processDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file);
                } else {
                    processSingleFile(file);
                }
            }
        }
    }

    private void processSingleFile(File file) {
        if (file.length() < MAX_FILE_SIZE) {
            try {
                fileDAO.saveFile(file);
            } catch (SQLException | IOException e) {
                System.out.println("Ошибка при сохранении файла " + file.getName() + ": " + e.getMessage());
            }
        } else {
            System.out.println("Файл больше 10 МБ: " + file.getName());
        }
    }
}
