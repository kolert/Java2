package lv.javaguru.java2.businesslogic.responses;

import lv.javaguru.java2.businesslogic.helper.Error;

public class Response {
    private boolean success;
    private Error error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Response(boolean success, Error error){
        this.success = success;
        this.error = error;
    }
}
