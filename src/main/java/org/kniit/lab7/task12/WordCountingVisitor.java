package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class WordCountingVisitor extends SimpleFileVisitor<Path> {

    private long totalWordCount = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().toLowerCase().endsWith(".txt")) {
            long wordCount = countWordsInFile(file);
            System.out.println("Файл: " + file.getFileName() + " Слов: " + wordCount);
            totalWordCount += wordCount;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Ошибка доступа к файлу: " + file + " (" + exc.getMessage() + ")");
        return FileVisitResult.CONTINUE;
    }

    public long getTotalWordCount() {
        return totalWordCount;
    }

    private long countWordsInFile(Path file) {
        long count = 0;
        try {
            List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] words = line.trim().split("\\s+");
                count += words.length;
            }
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл: " + file);
        }
        return count;
    }
}
