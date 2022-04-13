import java.util.Random;
public abstract class AccountHolder {
    protected int ID;
    protected String address;


    public AccountHolder(int ID, String address){
        this.ID = ID;
        this.address = address;
    }
    public static int getNextID(){
        Random rand = new Random();
        return rand.nextInt(1,1000000);
    }
}
