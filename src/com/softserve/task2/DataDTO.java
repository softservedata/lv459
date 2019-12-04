package com.softserve.task2;

import java.util.List;
import java.util.Objects;

public class DataDTO {


    private int x;
    private int y;

    public DataDTO(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public DataDTO() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataDTO dataDTO = (DataDTO) o;
        return x == dataDTO.x &&
                Objects.equals(y, dataDTO.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}

