package com.teamdev.javaclasses.brainfuck;

import java.io.OutputStream;

public interface Interpreter {

    String execute(String inputText, Memory memory, OutputStream outputStream);

}
