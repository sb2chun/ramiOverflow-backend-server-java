package com.miracom.backendramioverflow.config;

import com.miracom.backendramioverflow.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner {

    private final PostService postService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("------------------Boot on------------------");

//        postService.setupTestData();
    }
}
