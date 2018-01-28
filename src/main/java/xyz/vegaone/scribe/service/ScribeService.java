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

    private FileDiscoveryServiceImpl fileDiscoveryServiceImpl;

    private FileReaderServiceImpl fileReaderServiceImpl;

    public ScribeService() {
    }

    @Autowired
    public ScribeService(FileDiscoveryServiceImpl fileDiscoveryServiceImpl, FileReaderServiceImpl fileReaderServiceImpl) {
        this.fileDiscoveryServiceImpl = fileDiscoveryServiceImpl;
        this.fileReaderServiceImpl = fileReaderServiceImpl;
    }

    public Map<String, List<String>> discoverAndIndexFiles(String directoryPath) throws IOException {

        Map<String, List<String>> pathsFound = fileDiscoveryServiceImpl.discoverFiles(directoryPath);

        List<String> pdfPathList = pathsFound.get(ScribeConstants.PDF_FILE_FORMAT);
        fileReaderServiceImpl.fileListReader(pdfPathList);

        //TODO call a method to post the result to elastic search (this last method will be defined later).

        return pathsFound; // to be changed to the paths that were processed
    }

}
