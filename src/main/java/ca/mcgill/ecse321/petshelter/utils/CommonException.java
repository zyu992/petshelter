package ca.mcgill.ecse321.petshelter.utils;

public class CommonException extends Exception {
    private ResultCode resultCode;

    public CommonException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
}
