package com.teamdev.javaclasses.brainfuck;

public class Memory {

    private final int[] cells;
    private int pointer;

    public Memory(int size) {
        this.cells = new int[size];
    }

    public int getCurrentCellValue() {
        return cells[pointer];
    }

    public void movePointerToRight() {
        pointer++;
    }

    public void movePointerToLeft() {
        pointer--;
    }

    public void incrementCellValue() {
        cells[pointer]++;
    }

    public void decrementCellValue() {
        cells[pointer]--;
    }

}
