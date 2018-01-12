package xyz.vegaone.scribe.service;

import java.util.List;

public interface FileReaderService {
    List<String> contentReaderPdf();
    List<String> contentReaderExcel();
    List<String> contentReaderWord();
}
