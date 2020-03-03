public class ShopState extends State {
    public int currentCustomers;
    public int successfulCustomers;
    public int customersLeft;
    public int maxCustomers;
    public int availableCheckouts;
    public int totCheckouts;
    public int closeTime;
    public int seed;
    public int customerArrivalDelay;

    public CustomerFactory cFactory1;
    public FIFO checkoutQue;


    public ShopState(double lamba, double seed){
    	super(lamba, seed);
    	 cFactory1 = new CustomerFactory();
    	 checkoutQue = new FIFO();
    }
}
