package MuhammadFadhlanHarits.jwork;
/**
 * @author Muhammad Fadhlan Harits
 * @version 6 Mei 2021
 */
public class JobSeekerNotFoundException extends Exception
{
    private int jobseeker_error;
    /**
     * Konstruktur kelas jobseekernotfoundexception
     * @param jobseeker_input
     */
    public JobSeekerNotFoundException(int jobseeker_input)
    {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }
    /**
     *
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error + " not found";
    }
}
