/**
 * @author Muhammad Fadhlan Harits
 * @version 1 April 2021
 */
public class EwalletPayment extends Invoice
{
    //h your own
    private static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor for objects of class EwalletPayment
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    
    /**
    * <p>Method mengambil paymenttype sehingga memiliki paymenttype</p>
    * @return paymentType
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    /**
    * <p>Method mengambil bonus sehingga returnnya adalah bonus</p>
    * @return bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    /**
    * <p>Method mengambil bonus sehingga returnnya adalah bonus</p>
    * @param bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    /**
    * <p>Method memberi nilai totalfee</p>
    * 
     */
    public void setTotalFee()
    {
        if(bonus instanceof Bonus && bonus.getActive()==true && super.getJob().getFee() > bonus.getMinTotalFee())
        {
            totalFee = super.getJob().getFee() + bonus.getExtraFee();
        }
        super.totalFee = super.getJob().getFee();
    }
    //method menampilkan data
    public void printData()
    {
        System.out.println("==== INVOICE ====");
        System.out.println("ID: " + getId());
        System.out.println("Job : " + getJob().getCategory());
        System.out.println("Date: " + getDate());
        System.out.println("Jobseeker: " + getJobseeker().getName());
        System.out.println("Invoice Status: " + getInvoiceStatus());
        System.out.println("Payment type: " + getPaymentType());
        
        if(bonus instanceof Bonus && bonus.getActive()==true && super.getJob().getFee() > bonus.getMinTotalFee())
        {
            System.out.println("Total Fee: " + getTotalFee());
            System.out.println("Referral code: " + bonus.getReferralCode());
        }
    }
}
