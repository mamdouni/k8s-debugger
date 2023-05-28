package org.spring.example.k8s.debugger.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IpAddressService {

    private final Environment environment;

    public String getLocalHostAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    public String getLocalHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    public String getLoopHostAddress() {
        return InetAddress.getLoopbackAddress().getHostAddress();
    }

    public String getLoopHostName() {
        return InetAddress.getLoopbackAddress().getHostName();
    }

}
