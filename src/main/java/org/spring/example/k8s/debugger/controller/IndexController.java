package org.spring.example.k8s.debugger.controller;

import java.net.UnknownHostException;
import lombok.AllArgsConstructor;
import org.spring.example.k8s.debugger.service.ContainerService;
import org.spring.example.k8s.debugger.service.IpAddressService;
import org.spring.example.k8s.debugger.service.ServerPortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class IndexController {

    private final ContainerService containerService;
    private final IpAddressService ipAddressService;
    private final ServerPortService portService;

    @GetMapping("/")
    public String main(Model model) throws UnknownHostException {
        model.addAttribute("local_host_name", ipAddressService.getLocalHostName());
        model.addAttribute("local_host_address", ipAddressService.getLocalHostAddress());
        model.addAttribute("loop_host_name", ipAddressService.getLoopHostName());
        model.addAttribute("loop_host_address", ipAddressService.getLoopHostAddress());
        model.addAttribute("port", portService.getPort());
        model.addAttribute("node_name", containerService.getNodeName());
        model.addAttribute("version", containerService.getContainerTagVersion());
        return "index"; //view
    }
}
