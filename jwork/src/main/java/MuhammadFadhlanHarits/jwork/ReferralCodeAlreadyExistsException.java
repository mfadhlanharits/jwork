package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class ReferralCodeAlreadyExistsException extends Exception
{
    private Bonus referral_error;
    /**
     * Konstruktur kelas referralcodealreadyexistsexception
     * @param referral_input
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input)
    {
        super("Referral code: ");
        referral_error = referral_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + referral_error.getReferralCode() + " already exists";
    }
}
