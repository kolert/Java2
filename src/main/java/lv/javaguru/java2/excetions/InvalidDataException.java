package lv.javaguru.java2.excetions;

public class InvalidDataException extends Exception {
    private String message;
    private String field;

    public InvalidDataException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
