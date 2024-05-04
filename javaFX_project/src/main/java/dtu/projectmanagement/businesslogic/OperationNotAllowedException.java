package dtu.projectmanagement.businesslogic;
/**
@author huba
*/

public class OperationNotAllowedException extends Exception {


    public OperationNotAllowedException(String errorMessage) {
        super(errorMessage);
    }
}
