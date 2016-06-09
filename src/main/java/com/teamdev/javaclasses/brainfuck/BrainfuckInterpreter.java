package com.teamdev.javaclasses.brainfuck;

import java.util.Arrays;

public class BrainfuckInterpreter implements Interpreter {

    private final int MEMORY_SIZE = 10;

    public BrainfuckInterpreter() {
    }

    @Override
    public String interpret(String inputText) {

        final char[] inputTextCharArr = inputText.toCharArray();
        int[] array = new int[MEMORY_SIZE];

        StringBuilder finalString = new StringBuilder();
        int arrayIndex = 0;

        for (int i = 0; i < inputTextCharArr.length; i++) {

            if (arrayIndex == array.length) {

                int newMemorySize = arrayIndex * 2;
                array = Arrays.copyOf(array, newMemorySize);

            }

            switch (inputTextCharArr[i]) {

                case '+': {
                    array[arrayIndex] += 1;
                    break;
                }

                case '-': {
                    array[arrayIndex] -= 1;
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
                    finalString.append(Character.toChars(array[arrayIndex]));
                    break;
                }

                case '[': {

                    int loopCounter = 1;

                    if (array[arrayIndex] == 0) {

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

                    if (array[arrayIndex] != 0) {

                        while (loopCounter > 0) {

                            i--;

                            if (inputTextCharArr[i] == '[') {

                                loopCounter--;

                            }

                            if (inputTextCharArr[i] == ']') {

                                loopCounter++;

                            }

                        }

                    }

                    break;
                }

                default: {

                    throw new IllegalArgumentException("");

                }

            }

        }

        return finalString.toString();

    }

}
