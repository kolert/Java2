package lv.javaguru.java2.views.Products;

import lv.javaguru.java2.exceptions.InvalidDataException;
import lv.javaguru.java2.views.View;

public class ProgramExitView implements View {
    @Override
    public void execute(Object model) throws InvalidDataException {
        System.out.println("Good by!");
        System.exit(0);
    }
    @Override
    public Object get(Object model) throws InvalidDataException{
        return null;
    }
}
