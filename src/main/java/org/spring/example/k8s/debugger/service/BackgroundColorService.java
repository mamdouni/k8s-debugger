package org.spring.example.k8s.debugger.service;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class BackgroundColorService {

    private static final Random RANDOM = new Random();
    private final String pickedColor;

    public BackgroundColorService() {
        this.pickedColor = buildASetOfColors().get(RANDOM.nextInt(15));
    }

    private List<String> buildASetOfColors() {

        return List.of(
                "crimson",
                "black",
                "rebeccapurple",
                "midnightblue",
                "dodgerblue",
                "blueviolet",
                "burlywood",
                "chocolate",
                "darkolivegreen",
                "darkgreen",
                "greenyellow",
                "darkgrey",
                "deeppink",
                "magenta",
                "tomato"
        );
    }

    public String pickAColor(){

        return this.pickedColor;
    }
}
