package xyz.vegaone.scribe.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import xyz.vegaone.scribe.domain.FileEs;

import java.util.List;

public interface FileRepository extends ElasticsearchRepository<FileEs, String> {
    Page<FileEs> findByPath(String path, Pageable pageable);

    List<FileEs> findByPath(String path);
}
