
/**
 * @author Muhammad Fadhlan Harits
 * @version 25 Maret 2021
 */
public enum PaymentType
{
    //Nilai dari tiap label enum
    BankPayment("Bank Payment"),
    EwalletPayment("E-Wallet Payment");
    
    //variabel untuk konstruktur
    private final String PT;
    /**
     * Konstruktur untuk enum PaymentType
     * @param PT
     */
    PaymentType(String PT)
    {
        this.PT = PT;
    }
    /**
     * Method untuk mengembalikan enum dalam bentuk string
     * @return PT
     */
    public String toString()
    {
        return PT;
    }
}
