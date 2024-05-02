package dtu.projectmanagement.app;
/**
@author huba
*/

public class OperationNotAllowedException extends Exception {


    public OperationNotAllowedException(String errorMessage) {
        super(errorMessage);
    }
}
