package com.hy.service.storage.impl;

import com.hy.service.storage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @Author: wanghai
 * @Date:2019/7/11 11:31
 * @Copyright:reach-life
 * @Description:
 */
public class StorageServiceImpl implements StorageService {

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile multipartFile) {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
