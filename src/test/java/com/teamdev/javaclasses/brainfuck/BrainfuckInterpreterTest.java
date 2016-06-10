package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class BrainfuckInterpreterTest {

    private BrainfuckInterpreter interpreter = new BrainfuckInterpreter();

    @Test
    public void testHelloWorld() {
        String HELLO_WORLD = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---" +
                ".+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        assertEquals("Obtained value doesn\'t equals \'Hello World!\'",
                "Hello World!\n", interpreter.execute(HELLO_WORLD, new Memory(100), new ByteArrayOutputStream()));
    }

    @Test
    public void testNestedLoops() {
        assertEquals("Obtained value doesn\'t equals \'Q\'", "Q",
                interpreter.execute("+++[>+++[>+++[>+++<-]<-]<-]>>>.", new Memory(100), new ByteArrayOutputStream()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSymbol() {
        interpreter.execute("1", new Memory(100), new ByteArrayOutputStream());
    }

}