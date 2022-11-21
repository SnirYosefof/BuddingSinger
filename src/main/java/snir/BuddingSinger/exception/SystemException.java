package snir.BuddingSinger.exception;

//Created by sniryosefof on 25 ספט׳
public class SystemException extends Exception {
    private Err err;
    public SystemException(Err err) {
        super(err.getMsg());
    }
}
