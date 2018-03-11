package lv.javaguru.java2.views;

import lv.javaguru.java2.exceptions.InvalidDataException;

public interface View {

    void execute(Object model) throws InvalidDataException;
    Object get(Object model) throws InvalidDataException;

}
