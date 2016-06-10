package com.teamdev.javaclasses.brainfuck;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class BrainfuckInterpreter implements Interpreter {

    @Override
    public String execute(String inputText, Memory memory, OutputStream outputStream) {

        final char[] inputTextCharArr = inputText.toCharArray();

        final Deque<Integer> cyclesDeque = new ArrayDeque<>();

        for (int i = 0; i < inputTextCharArr.length; i++) {

            switch (inputTextCharArr[i]) {

                case '+': {
                    memory.incrementCellValue();
                    break;
                }

                case '-': {
                    memory.decrementCellValue();
                    break;
                }

                case '>': {
                    memory.movePointerToRight();
                    break;
                }

                case '<': {
                    memory.movePointerToLeft();
                    break;
                }

                case '.': {
                    try {
                        outputStream.write((char) memory.getCurrentCellValue());
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }
                    break;
                }

                case '[': {

                    int loopCounter = 1;

                    cyclesDeque.addLast(i);

                    if (memory.getCurrentCellValue() == 0) {

                        while (loopCounter > 0) {

                            i++;

                            if (inputTextCharArr[i] == '[') {

                                loopCounter++;

                            }

                            if (inputTextCharArr[i] == ']') {

                                loopCounter--;

                            }

                        }

                    }

                    break;
                }

                case ']': {

                    if (cyclesDeque.isEmpty()) {
                        throw new IllegalArgumentException("Given text is not correct: " +
                                "number of opened and closed braces does not match!");
                    }

                    if (memory.getCurrentCellValue() != 0) {

                        i = cyclesDeque.getLast();

                    } else {

                        cyclesDeque.removeLast();

                    }

                    break;
                }

                default: {

                    throw new IllegalArgumentException("Such command is not allowed in Brainfuck language!");

                }

            }

        }

        if (!cyclesDeque.isEmpty()) {
            throw new IllegalArgumentException("Given text is not correct: " +
                    "number of opened and closed braces does not match!");
        }



        return outputStream.toString();

    }

}
