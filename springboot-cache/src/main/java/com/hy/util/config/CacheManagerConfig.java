package com.hy.util.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * @Author: wanghai
 * @Date:2019/6/29 23:18
 * @Copyright:reach-life
 * @Description:
 */
public class CacheManagerConfig implements CacheManager {
    @Override
    public Cache getCache(String s) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
}
