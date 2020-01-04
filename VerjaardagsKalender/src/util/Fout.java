package util;



public class Fout extends Exception {

    public Fout(String melding){
        super(melding);
    }

    
    public String getMessage() {
        return super.getMessage();
    }
}
