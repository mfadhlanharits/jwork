import java.util.ArrayList;

/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
public class DatabaseJobseeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<>();
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
     * @return JOBSEEKER DATABASE
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * Akan mengembalikan profesi berdasarkan id sehingga returnnya null
     * @param  id
     */
    public static Jobseeker getJobseekerById(int id)
    {
        Jobseeker js1 = null;
        for(Jobseeker js : JOBSEEKER_DATABASE){
            if(js.getID() == id){
                js1 = js;
            }
            else{
                return null;
            }
        }
        return js1;
    }
    /**
     * Akan menambah pelamar sehingga parameternya jobseeker
     * @param jobseeker
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        for (int i=0;i<JOBSEEKER_DATABASE.size();i++){
            if(JOBSEEKER_DATABASE.get(i).getEmail() == jobseeker.getEmail()){
                return false;
            }
        }

        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getID();
        return true;
    }
   /**
     * Akan menghapus pelamar sehingga parameternya jobseeker
     * @param id
     */
    public static boolean removeJobseeker(int id)
    {
        boolean b = true;
        for(Jobseeker js : JOBSEEKER_DATABASE){
            if(js.getID() == id){
                JOBSEEKER_DATABASE.remove(js);
                b = true;
            }
            else{
                b = false;
            }
        }
        return b;
    }


}
