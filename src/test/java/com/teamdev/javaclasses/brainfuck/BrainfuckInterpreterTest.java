package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckInterpreterTest {

    private BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
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
        assertEquals("Obtained value's length doesn\'t equals 2", 2, interpreter.interpret("..").length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSymbol() {
        interpreter.interpret("1");
    }

    @Test
    public void testPlusCommand() {
        interpreter.interpret("+");
        assertTrue("", interpreter.getOutputArray()[0] == 1);
    }

    @Test
    public void testMinusCommand() {
        interpreter.interpret("+++-");
        assertTrue("", interpreter.getOutputArray()[0] == 2);
    }

    @Test
    public void testForwardCommand() {
        interpreter.interpret(">+++");
        assertTrue("", interpreter.getOutputArray()[1] == 3);
    }


    @Test
    public void testBackCommand() {
        interpreter.interpret(">>++<");
        assertTrue("", interpreter.getOutputArray()[1] == 0);
    }

}