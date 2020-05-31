package dev.fr13.customerdisplay.exception;

public class EmptyFileUploadingException extends RuntimeException {

    public EmptyFileUploadingException() {
        super("file can't be empty.");
    }
}
