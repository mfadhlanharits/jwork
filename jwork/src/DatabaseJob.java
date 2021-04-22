
/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
import java.util.ArrayList;
public class DatabaseJob
{
    // variabel yang digunakan
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId=0;

    /**
     * Akan mengembalikan profesi sehingga returnnya null
     * @return null
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
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
    public static Job getJobById(int id)
    {
        Job j1=null;
        for(Job j : JOB_DATABASE){
            if(j.getId()==id){
                j1 = j;
            }
            else {
                return null;
            }
        }
        return j1;
    }
    /**
     * Akan mengembalikan profesi berdasarkan id recruitersehingga returnnya null
     * @param recruiterId
     */
    public static ArrayList<Job> getByRecruiter(int recruiterId)
    {
        ArrayList<Job> gbr = new ArrayList<>();
        for(Job jj : JOB_DATABASE){
            if(jj.getRecruiter().getID() == recruiterId){
                gbr.add(jj);
            }
            else {
                return null;
            }
        }

        return gbr;
    }
    /**
     * Akan mengembalikan profesi berdasarkan kategori sehingga paramnya kategori
     * @param category
     */
    public static ArrayList<Job> getByCategory(JobCategory category)
    {
        ArrayList<Job> gbc = new ArrayList<>();
        for(Job jj : JOB_DATABASE){
            if(jj.getCategory() == category){
                gbc.add(jj);
            }
            else {
                return null;
            }
        }
        return gbc;
    }
    /**
     * Akan menambah profesi sehingga parameternya job
     * @param job
     */
    public static boolean addJob(Job job)
    {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }
   /**
     * Akan menghapus profesi sehingga parameternya id
     * @param id
     */
    public static boolean removeJob(int id)
    {
        boolean b = true;
        for(Job j : JOB_DATABASE){
            if(j.getId() == id){
                JOB_DATABASE.remove(j);
                b = true;
            }
            else{
                b = false;
            }
        }

        return b;
    }
}
