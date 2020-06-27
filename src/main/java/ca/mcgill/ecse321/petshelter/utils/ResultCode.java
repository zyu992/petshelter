package ca.mcgill.ecse321.petshelter.utils;

public enum ResultCode {
    SUCCESS(true, 202, "Succeeded"),
    FAIL(false, 200, "Failed"),
    UNAUTHENTICATED(false, 401, "Not logged in"),
    UNAUTHORIZED(false, 401, "Unauthorized"),
    SERVER_ERROR(false, 503, "Server error"),
    USERNAME_OR_PASSWORD_ERROR(false, 401, "Credentials do not match with our records");

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
