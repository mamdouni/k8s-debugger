package org.spring.example.k8s.debugger.controller;

import java.net.UnknownHostException;
import lombok.AllArgsConstructor;
import org.spring.example.k8s.debugger.service.BackgroundColorService;
import org.spring.example.k8s.debugger.service.ContainerService;
import org.spring.example.k8s.debugger.service.IpAddressService;
import org.spring.example.k8s.debugger.service.ServerPortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexController {

    private final ContainerService containerService;
    private final IpAddressService ipAddressService;
    private final ServerPortService portService;
    private final BackgroundColorService colorService;

    @GetMapping("/")
    public String main(Model model) throws UnknownHostException {
        model.addAttribute("hostname", ipAddressService.getLocalHostName());
        model.addAttribute("ip_address", ipAddressService.getLocalHostAddress());
        model.addAttribute("port", portService.getPort());
        model.addAttribute("node_name", containerService.getNodeName());
        model.addAttribute("version", containerService.getContainerTagVersion());
        model.addAttribute("color", colorService.pickAColor());
        return "index"; //view
    }
}
