/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class JobNotFoundException extends Exception
{
    private int job_error;
    /**
     * Konstruktur kelas jobnotfoundexception
     * @param job_input
     */
    public JobNotFoundException(int job_input)
    {
        super("Job ID: ");
        job_error = job_input;
    }
    /**
     *
     */
    public String getMessage()
    {
        return super.getMessage() + job_error + " not found";
    }
}
