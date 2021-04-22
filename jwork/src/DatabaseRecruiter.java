import java.util.ArrayList;

/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
public class DatabaseRecruiter
{
    // variabel yang digunakan
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<>();
    private static int lastId=0;
    /**
     * akan mengembalikan recruiterdatabase
     * @return RECRUITER_DATABASE
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
    }
    /**
     * akan mengembalikan id terakhir
     * @return lastId
     */
    public static int getLastId()
    {
        return lastId;
    }
    /**
     * akan mengembalikan recruiter
     * @param id
     * @return null
     */
    public static Recruiter getRecruiterById(int id)
    {
        Recruiter r1=null;
        for(int i=0;i<RECRUITER_DATABASE.size();i++){
            if(RECRUITER_DATABASE.get(i).getID() == id){
                r1 = RECRUITER_DATABASE.get(i);
            }
            else {
                return null;
            }
        }
        return r1;
    }
    /**
     * akan menambahkan recruiter sehingga parameternya recruiter
     * @param  recruiter
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getID();
        return true;
    }
    /**
     * akan menghapus recruiter sehingga parameternya id
     * @param  id
     */
    public static boolean removeRecruiter(int id)
    {
        boolean b = true;
        for(int i=0;i<RECRUITER_DATABASE.size();i++){
            if(RECRUITER_DATABASE.get(i).getID() == id){
                RECRUITER_DATABASE.remove(i);
                b = true;
            }
            else {
                b = false;
            }
        }
        return b;
    }

}
