package xyz.vegaone.scribe.dto;

import java.util.Map;

public class FileDto {

    private String path;

    private Map<Integer, String> fileContent;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<Integer, String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(Map<Integer, String> fileContent) {
        this.fileContent = fileContent;
    }
}
