package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class EmailAlreadyExistsException extends Exception
{
    private Jobseeker jobseeker_error;
    /**
     * Konstruktur kelas emailalreadyexistsexception
     * @param jobseeker_input
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input)
    {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }
    /**
     * Method untuk menampilkan pesan sehingga returnnya getmessage
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists";
    }
}
