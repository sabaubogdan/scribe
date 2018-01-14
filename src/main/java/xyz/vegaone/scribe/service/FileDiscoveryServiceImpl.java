package xyz.vegaone.scribe.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileDiscoveryServiceImpl implements FileDiscoveryService {

    public static void main(String[] args) {
        FileDiscoveryServiceImpl fileDiscoveryService = new FileDiscoveryServiceImpl();

        Map<String, List<String>> savedMap = fileDiscoveryService.discoverFiles("C:\\Test");

    }

    @Override
    public Map<String, List<String>> discoverFiles(String directoryPath) {

        List<String> txtList = new ArrayList();
        List<String> docList = new ArrayList();
        List<String> pdfList = new ArrayList();
        List<String> unknownFormat = new ArrayList();

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath), Integer.MAX_VALUE)) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    if (filePath.toString().endsWith("txt")) {
                        txtList.add(filePath.toString());
                    } else if (filePath.toString().endsWith("doc")) {
                        docList.add(filePath.toString());
                    } else if (filePath.toString().endsWith("pdf")) {
                        pdfList.add(filePath.toString());
                    } else {
                        unknownFormat.add(filePath.toString());
                    }
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Map<String, List<String>> foundFiles = new HashMap<>();
        foundFiles.put("txt", txtList);
        foundFiles.put("doc", docList);
        foundFiles.put("pdf", pdfList);
        foundFiles.put("unknown", unknownFormat);

        return foundFiles;
    }
}
