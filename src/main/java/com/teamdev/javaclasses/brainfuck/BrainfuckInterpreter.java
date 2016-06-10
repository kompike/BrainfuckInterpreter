package com.teamdev.javaclasses.brainfuck;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class BrainfuckInterpreter implements Interpreter {

    private int[] memory = null;

    public BrainfuckInterpreter() {
    }

    public int[] getMemory() {
        return memory;
    }

    @Override
    public String execute(String inputText) {

        final char[] inputTextCharArr = inputText.toCharArray();
        int memorySize = 10;
        memory = new int[memorySize];

        final int openBracesNumber = StringUtils.countMatches(inputText, '[');
        final int closeBracesNumber = StringUtils.countMatches(inputText, ']');

        if (openBracesNumber != closeBracesNumber) {
            throw new IllegalArgumentException("Given text is not correct: number of opened and closed braces does not match!");
        }

        Deque<Integer> openBracesIndexesKeeper = new ArrayDeque<>();
        StringBuilder interpretedString = new StringBuilder();
        int pointer = 0;

        for (int i = 0; i < inputTextCharArr.length; i++) {

            if (pointer == memory.length) {

                int newMemorySize = pointer * 2;
                memory = Arrays.copyOf(memory, newMemorySize);

            }

            switch (inputTextCharArr[i]) {

                case '+': {
                    memory[pointer] += 1;
                    break;
                }

                case '-': {
                    memory[pointer] -= 1;
                    break;
                }

                case '>': {
                    ++pointer;
                    break;
                }

                case '<': {
                    --pointer;
                    break;
                }

                case '.': {
                    interpretedString.append(Character.toChars(memory[pointer]));
                    break;
                }

                case '[': {

                    int loopCounter = 1;

                    openBracesIndexesKeeper.addLast(i);

                    if (memory[pointer] == 0) {

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

                    if (memory[pointer] != 0) {

                        i = openBracesIndexesKeeper.getLast();

                    } else {

                        openBracesIndexesKeeper.removeLast();

                    }

                    break;
                }

                default: {

                    throw new IllegalArgumentException("Such command is not allowed in Brainfuck language!");

                }

            }

        }

        return interpretedString.toString();

    }

}
