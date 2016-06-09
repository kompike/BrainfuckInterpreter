package com.teamdev.javaclasses.brainfuck;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrainfuckInterpreterTest {

    private Interpreter interpreter = new BrainfuckInterpreter();
    private String helloWorld = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---" +
            ".+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";

    @Test
    public void testHelloWorld() {
        assertEquals("Obtained value doesn\'t equals \'Hello World!\'", "Hello World!\n", interpreter.interpret(helloWorld));
    }

    @Test
    public void testPlusCommand() {
        assertEquals("Obtained value doesn\'t equals \'1\'", "1", interpreter.interpret("+"));
    }

    @Test
    public void testMinusCommand() {
        assertEquals("Obtained value doesn\'t equals \'-1\'", "-1", interpreter.interpret("-"));
    }

    @Test
    public void testForwardCommand() {
        assertEquals("Forward command doesn't execute", ">", interpreter.interpret(">"));
    }

    @Test
    public void testBackCommand() {
        assertEquals("Back command doesn't execute", "<", interpreter.interpret("<"));
    }

}