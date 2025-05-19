package ua.edu.ukma.stasiuk.nativeplayground.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ValueService {

    private final Random random = new Random();

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public boolean getConstantTrue() {
        return true;
    }

    public boolean getConstantFalse() {
        return false;
    }

    public String getSomeString() {
        return "foobar";
    }
}
