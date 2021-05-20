package MuhammadFadhlanHarits.jwork;
import java.util.ArrayList;

/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
public class DatabaseJobseeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId=0;
    /**
     * Akan mengembalikan database pelamar sehingga returnnya JOBSEEKER_DATABASE
     * @return JOBSEEKER DATABASE
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }
    /**
     * Akan mengembalikan id terakhir sehingga returnnya lastId
     * @return lastId
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * Akan mengembalikan profesi berdasarkan id sehingga returnnya null
     * @param  id
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException
    {
        Jobseeker js1 = null;
        for(Jobseeker js : JOBSEEKER_DATABASE){
            if(js.getID() == id){
                js1 = js;
            }
        }
        if(js1==null)
        {
            JobSeekerNotFoundException e = new JobSeekerNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return js1;
    }
    /**
     * Akan menambah pelamar sehingga parameternya jobseeker
     * @param jobseeker
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        boolean b=true;
        for (int i=0;i<JOBSEEKER_DATABASE.size();i++){
            if(JOBSEEKER_DATABASE.get(i).getEmail() == jobseeker.getEmail()){
                b=false;
            }
        }
        if(b==false)
        {
            EmailAlreadyExistsException e = new EmailAlreadyExistsException(jobseeker);
            System.out.println(e.getMessage());
            return b;
        }
        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getID();
        return b;
    }
   /**
     * Akan menghapus pelamar sehingga parameternya jobseeker
     * @param id
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException
    {
        boolean b = false;
        for(Jobseeker js : JOBSEEKER_DATABASE){
            if(js.getID() == id){
                JOBSEEKER_DATABASE.remove(js);
                b = true;
            }
        }
        if(b==false)
        {
            JobSeekerNotFoundException e = new JobSeekerNotFoundException(id);
            System.out.println(e.getMessage());
        }
        return b;
    }

    /**
     * Akan mengembalikan profesi berdasarkan id sehingga returnnya null
     * @param  email, password
     */
    public static Jobseeker jobseekerLogin(String email, String password)
    {
        Jobseeker js1 = null;
        for(Jobseeker js : JOBSEEKER_DATABASE){
            if(js.getEmail().equals(email) && js.getPassword().equals(password)){
                js1 = js;
            }
        }

        return js1;
    }

}
