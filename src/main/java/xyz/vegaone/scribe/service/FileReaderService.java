package xyz.vegaone.scribe.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileReaderService {
    Map<Integer, String> contentReaderPdf() throws IOException;
    Map<Integer, String> contentReaderExcel();
    Map<Integer, String> contentReaderWord();
}
