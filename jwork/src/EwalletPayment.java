import java.text.SimpleDateFormat;

/**
 * @author Muhammad Fadhlan Harits
 * @version 10 April 2021
 */
public class EwalletPayment extends Invoice
{
    //variabel yang digunakan
    private static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Konstruktur kelas EwalletPayment
     * @param id, job, date, jobseeker, invoicestatus
     */
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, jobseeker, invoiceStatus);
    }
    /**
     * Konstruktur kelas EwalletPayment
     * @param id, job, date, jobseeker, invoicestatus, bonus
     */
    public EwalletPayment(int id, Job job, Jobseeker jobseeker, InvoiceStatus invoiceStatus, Bonus bonus)
    {
        super(id, job, jobseeker, invoiceStatus);
        super.setDate(getDate());
        this.bonus = bonus;
    }
    
    /**
    * <p>Method mengambil paymenttype sehingga memiliki return paymenttype</p>
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
    * <p>Method menmberi nilai bonus sehingga paramnya adalah bonus</p>
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
        if(bonus != null && (bonus.getActive()==true) && getJob().getFee() >= bonus.getMinTotalFee())
        {
            totalFee = getJob().getFee() + bonus.getExtraFee();
        }
        else
        {
            totalFee = getJob().getFee();
        }
    }
    //method menampilkan data
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        if(bonus != null && (bonus.getActive() == true) && getJob().getFee() >= bonus.getMinTotalFee())
        {
            return "==== PAYMENT ====" + "\nID: " + getId() + "\nJob : " + getJob().getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nReferral code: " + bonus.getReferralCode() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();
        }
        return "==== PAYMENT ====" + "\nID: " + getId() + "\nJob : " + getJob().getName() + "\nDate: " + sdf.format(getDate().getTime()) + "\nJobseeker: " + getJobseeker().getName() + "\nTotal Fee: " + getTotalFee() + "\nInvoice Status: " + getInvoiceStatus() + "\nPayment type: " + getPaymentType();
    }
}
