package org.spring.example.k8s.debugger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class BackgroundColorService {

    private static final Random RANDOM = new Random();
    private final List<String> colors;

    public BackgroundColorService() {

        this.colors = new ArrayList<>();
        this.colors.add("crimson");
        this.colors.add("black");
        this.colors.add("rebeccapurple");
        this.colors.add("midnightblue");
        this.colors.add("dodgerblue");
        this.colors.add("blueviolet");
        this.colors.add("burlywood");
        this.colors.add("chocolate");
        this.colors.add("darkolivegreen");
        this.colors.add("darkgreen");
        this.colors.add("greenyellow");
        this.colors.add("darkgrey");
        this.colors.add("deeppink");
        this.colors.add("magenta");
        this.colors.add("tomato");
    }

    public String pickAColor(){

        return colors.get(RANDOM.nextInt(15));
    }
}
