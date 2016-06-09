package com.teamdev.javaclasses.brainfuck;

import java.util.Arrays;

public class BrainfuckInterpreter implements Interpreter {

    private final int MEMORY_SIZE = 10;
    private int[] outputArray = null;

    public BrainfuckInterpreter() {
    }

    public int[] getOutputArray() {
        return outputArray;
    }

    @Override
    public String interpret(String inputText) {

        final char[] inputTextCharArr = inputText.toCharArray();
        outputArray = new int[MEMORY_SIZE];

        StringBuilder interpretedString = new StringBuilder();
        int arrayIndex = 0;

        for (int i = 0; i < inputTextCharArr.length; i++) {

            if (arrayIndex == outputArray.length) {

                int newMemorySize = arrayIndex * 2;
                outputArray = Arrays.copyOf(outputArray, newMemorySize);

            }

            switch (inputTextCharArr[i]) {

                case '+': {
                    outputArray[arrayIndex] += 1;
                    break;
                }

                case '-': {
                    outputArray[arrayIndex] -= 1;
                    break;
                }

                case '>': {
                    ++arrayIndex;
                    break;
                }

                case '<': {
                    --arrayIndex;
                    break;
                }

                case '.': {
                    interpretedString.append(Character.toChars(outputArray[arrayIndex]));
                    break;
                }

                case '[': {

                    int loopCounter = 1;

                    if (outputArray[arrayIndex] == 0) {

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

                    int loopCounter = 1;

                    if (outputArray[arrayIndex] != 0) {

                        while (loopCounter > 0) {

                            i--;

                            if (inputTextCharArr[i] == '[') {

                                loopCounter--;

                            }

                            if (inputTextCharArr[i] == ']') {

                                loopCounter++;

                            }

                        }

                        i--;

                    }

                    break;
                }

                default: {

                    throw new IllegalArgumentException("Such command isn\'t allowed in Brainfuck language!");

                }

            }

        }

        return interpretedString.toString();

    }

}
