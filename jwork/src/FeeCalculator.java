/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class FeeCalculator implements Runnable
{
    private int id;
    public FeeCalculator(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    @Override
    public void run()
    {
        System.out.println("Calculating invoice ID: " + getId());
        DatabaseInvoice.getInvoiceById(id).setTotalFee();
        System.out.println("Total fee" + DatabaseInvoice.getInvoiceById(id).getTotalFee());
        System.out.println("Finish calculating : " + getId());
    }
}
