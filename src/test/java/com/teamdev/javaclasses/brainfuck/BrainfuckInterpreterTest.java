package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckInterpreterTest {

    private BrainfuckInterpreter interpreter = new BrainfuckInterpreter();
    private final String HELLO_WORLD = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---" +
            ".+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

    @Test
    public void testHelloWorld() {
        assertEquals("Obtained value doesn\'t equals \'Hello World!\'", "Hello World!\n", interpreter.execute(HELLO_WORLD));
    }

    @Test
    public void testNestedLoops() {
        assertEquals("Obtained value doesn\'t equals \'Q\'", "Q", interpreter.execute("+++[>+++[>+++[>+++<-]<-]<-]>>>."));
    }

    @Test
    public void testPrintCommand() {
        assertEquals("Print command doesn't work properly!", 2, interpreter.execute("..").length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalSymbol() {
        interpreter.execute("1");
    }

    @Test
    public void testPlusCommand() {
        interpreter.execute("+");
        assertTrue("Increment command doesn\'t work properly!", interpreter.getMemory()[0] == 1);
    }

    @Test
    public void testMinusCommand() {
        interpreter.execute("+++-");
        assertTrue("Decrement command doesn't work properly!", interpreter.getMemory()[0] == 2);
    }

    @Test
    public void testForwardCommand() {
        interpreter.execute(">+++");
        assertTrue("Forward command doesn't work properly!", interpreter.getMemory()[1] == 3);
    }


    @Test
    public void testBackCommand() {
        interpreter.execute(">>++<");
        assertTrue("Back command doesn't work properly!", interpreter.getMemory()[1] == 0);
    }

}