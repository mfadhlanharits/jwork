package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 27 Maret 2021
 */
public enum InvoiceStatus
{
    //Nilai dari tiap label enum
    OnGoing("OnGoing"),
    Finished("Finished"), 
    Cancelled("Cancelled");
    
    //variabel untuk konstruktur
    private final String IS;
    /**
     * Konstruktur untuk enum InvoiceStatus
     * @param IS
     */
    InvoiceStatus(String IS)
    {
        this.IS = IS;
    }
    /**
     * Method untuk mengembalikan enum dalam bentuk string
     * @return IS
     */
    public String toString()
    {
        return IS;
    }
}
