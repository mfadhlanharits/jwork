/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class BonusNotFoundException extends Exception
{
    private int bonus_error;
    /**
     * Konstruktur kelas bonusnotfoundexception
     * @param bonus_input
     */
    public BonusNotFoundException(int bonus_input)
    {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + bonus_error + " not found";
    }
}
