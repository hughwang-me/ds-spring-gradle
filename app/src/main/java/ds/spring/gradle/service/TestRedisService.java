package ds.spring.gradle.service;

public interface TestRedisService {

    void add(String key , String value);

    String get(String key);
}
