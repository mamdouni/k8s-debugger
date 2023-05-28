package org.spring.example.k8s.debugger.service;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ContainerService implements InitializingBean {
    private String nodeName;
    private String containerTagVersion;

    @Override
    public void afterPropertiesSet() {
        nodeName = System.getenv("NODE_NAME");
        containerTagVersion = System.getenv("APP_VERSION");
    }

}
