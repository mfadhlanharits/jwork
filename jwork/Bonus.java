
/**
 * @author Muhammad Fadhlan Harits
 * @version 8 April 2021
 */
public class Bonus
{
    // variabel yang digunakan
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;
    /**
    * <p>Konstruktur bonus</p>
    * @param id, referralCode, extraFee, minTotalFee, active
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }
    /**
    * <p>Method mengambil id bonus sehingga memiliki return id</p>
    * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
    * <p>Method mengambil referral code sehingga returnnya adalah referral code</p>
    * @return referralcode
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    /**
    * <p>Method mengembalikan extrafee</p>
    * @return extraFee
     */
    public int getExtraFee()
    {
        return extraFee;
    }
    /**
    * <p>Method mengambil mintotalfee </p>
    * @return minTotalFee
     */
    public int getMinTotalFee()
    {
        return minTotalFee;
    }
    /**
    * <p>Method mengembalikan status aktif</p>
    * @return active
     */
    public boolean getActive()
    {
        return active;
    }
     /**
    * <p>Method memberikan nilai pada id</p>
    * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
     /**
    * <p>Method memberikan nilai pada referralCode</p>
    * @param referralCode
     */
     public void setReferralCode(String referralCode)
    {
        this.referralCode = referralCode;
    }
     /**
    * <p>Method memberikan nilai pada extraFee</p>
    * @param extraFee
     */
    public void setExtraFee(int extraFee)
    {
        this.extraFee = extraFee;
    }
    /**
    * <p>Method memberikan nilai pada minTotalFee</p>
    * @param minTotalFee
     */
     public void setMinTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
     /**
    * <p>Method memberikan nilai pada status aktif</p>
    * @param active
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    //Method untuk menampilkan data
    public String toString()
    {
        return "\nID: " + getId() + "\nReferral Code: " + getReferralCode() + "\nExtra Fee: " + getExtraFee() + "\nMin Total Fee: " + getMinTotalFee() + "\nActive Status: " + getActive();
    }
}
