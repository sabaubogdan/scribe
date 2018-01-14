package xyz.vegaone.scribe.service;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class FileDiscoveryServiceImpl implements FileDiscoveryService {
    private static final String TEXT_FINAL_FORMAT = "txt";
    private static final String PDF_FINAL_FORMAT = "pdf";
    private static final String DOC_FINAL_FORMAT = "doc";
    private static final String UNKNOWN_FINAL_FORMAT = "unknown";


    @Override
    public Map<String, List<String>> discoverFiles(String directoryPath) {

        List<String> txtList = new ArrayList();
        List<String> docList = new ArrayList();
        List<String> pdfList = new ArrayList();
        List<String> unknownFormat = new ArrayList();

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath), Integer.MAX_VALUE)) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    if (filePath.toString().endsWith(TEXT_FINAL_FORMAT)) {
                        txtList.add(filePath.toString());
                    } else if (filePath.toString().endsWith(DOC_FINAL_FORMAT)) {
                        docList.add(filePath.toString());
                    } else if (filePath.toString().endsWith(PDF_FINAL_FORMAT)) {
                        pdfList.add(filePath.toString());
                    } else {
                        unknownFormat.add(filePath.toString());
                    }
                }
            });
        } catch (IOException e) {
            System.out.println("Error while discovering files" + e.getMessage());
        }

        Map<String, List<String>> filePathsFound = new HashMap<>();
        filePathsFound.put(TEXT_FINAL_FORMAT, txtList);
        filePathsFound.put(DOC_FINAL_FORMAT, docList);
        filePathsFound.put(PDF_FINAL_FORMAT, pdfList);
        filePathsFound.put(UNKNOWN_FINAL_FORMAT, unknownFormat);

        return filePathsFound;
    }
}
