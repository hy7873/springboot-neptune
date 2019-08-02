package com.hy.service.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @Author: wanghai
 * @Date:2019/7/11 11:20
 * @Copyright:reach-life
 * @Description:
 */
public interface StorageService {

    void init();

    void store(MultipartFile multipartFile);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
