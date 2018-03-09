package lv.javaguru.java2.views;

import lv.javaguru.java2.excetions.InvalidDataException;

import java.util.List;

public interface View {

    void execute(Object model) throws InvalidDataException;
    Object get(Object model) throws InvalidDataException;

}
