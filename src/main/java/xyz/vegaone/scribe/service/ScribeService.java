package xyz.vegaone.scribe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ScribeService {

    private FileDiscoveryService fileDiscoveryService;

    private FileReaderService fileReaderService;

    public ScribeService() {
    }

    @Autowired
    public ScribeService(FileDiscoveryService fileDiscoveryService, FileReaderService fileReaderService) {
        this.fileDiscoveryService = fileDiscoveryService;
        this.fileReaderService = fileReaderService;
    }

    public Map<String, List<String>> discoverAndIndexFiles(String directoryPath) throws IOException {

        Map<String, List<String>> pathsFound = fileDiscoveryService.discoverFiles(directoryPath);

        List<String> pdfPathList = pathsFound.get(ScribeConstants.PDF_FILE_FORMAT);
        fileReaderService.contentReaderPdfList(pdfPathList);

        //TODO call a method to post the result to elastic search (this last method will be defined later).

        return pathsFound; // to be changed to the paths that were processed
    }

}
