package com.skaleras.metronome;
import java.io.InputStream;
public class Dummy {
    public static void main(String[] args) {
        InputStream stream = Dummy.class.getResourceAsStream("/resources/test.txt");
        System.out.println(stream != null);
        stream = Dummy.class.getClassLoader().getResourceAsStream("resources/test.txt");
        System.out.println(stream != null);
    }
}
