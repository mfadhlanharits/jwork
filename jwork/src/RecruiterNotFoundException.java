/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class RecruiterNotFoundException extends Exception
{
    private int recruiter_error;
    /**
     * Konstruktur kelas recruiternotfoundexception
     * @param recruiter_input
     */
    public RecruiterNotFoundException(int recruiter_input)
    {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + recruiter_error + " not found";
    }
}
