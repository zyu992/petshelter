package ca.mcgill.ecse321.petshelter.utils;

public enum ResultCode {
    SUCCESS(true, 10000, "Succeeded"),
    FAIL(false, 10001, "Failed"),
    UNAUTHENTICATED(false, 10002, "Not logged in"),
    UNAUTHORIZED(false, 10003, "Unauthorized"),
    SERVER_ERROR(false, 99999, "Server error");

    boolean success;
    int code;
    String message;

    ResultCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
