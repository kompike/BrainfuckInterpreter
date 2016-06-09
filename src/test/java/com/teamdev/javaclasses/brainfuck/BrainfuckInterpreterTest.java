package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckInterpreterTest {

    private Interpreter interpreter = new BrainfuckInterpreter();
    private final String HELLO_WORLD = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---" +
            ".+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

    @Test
    public void testHelloWorld() {
        assertEquals("Obtained value doesn\'t equals \'Hello World!\'", "Hello World!\n", interpreter.interpret(HELLO_WORLD));
    }

    @Test
    public void testBrainfuckCommands() {
        assertEquals("Obtained value doesn\'t equals \'Q\'", "Q", interpreter.interpret("+++[>+++[>+++[>+++<-]<-]<-]>>>."));
    }

    @Test
    public void testPrintCommand() {
        assertEquals("Obtained value's length doesn\'t equals 1", 1, interpreter.interpret("++++++++[>++++++++<-]>+.").length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSymbol() {
        interpreter.interpret("1");
    }

}