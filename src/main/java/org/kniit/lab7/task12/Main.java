package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path startDir = Paths.get("test_lab7");

        if (!Files.exists(startDir)) {
            System.out.println("Директория " + startDir.toAbsolutePath() + " не найдена.");
            return;
        }

        try {
            System.out.println("Начинаем обход файлов в: " + startDir.toAbsolutePath());

            WordCountingVisitor visitor = new WordCountingVisitor();

            Files.walkFileTree(startDir, visitor);

            System.out.println("Общее количество слов во всех .txt файлах: " + visitor.getTotalWordCount());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
