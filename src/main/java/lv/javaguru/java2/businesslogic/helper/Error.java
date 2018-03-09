package lv.javaguru.java2.businesslogic.helper;

public class Error {
    private String field;
    private String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error (String field, String message){
        this.field = field;
        this.message = message;

    }
}
