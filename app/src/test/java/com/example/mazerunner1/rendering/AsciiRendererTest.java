package com.example.mazerunner1.rendering;

import com.example.mazerunner1.StringConverter;

import org.junit.Assert;
import org.junit.Test;

public class AsciiRendererTest {

    int height = 40;
    AsciiRenderer renderer = new AsciiRenderer(height);
    @Test
    public void renderFrom() {
        StringConverter converter = new StringConverter();
        for (float i = 0; i<12; i+=.3) {
            System.out.println(converter.charLineToString(renderer.renderColumn(i)));
        }

    }
}