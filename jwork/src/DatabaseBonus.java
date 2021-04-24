/**
 * @author Muhammad Fadhlan Harits
 * @version 22 April 2021
 */
import java.util.ArrayList;
public class DatabaseBonus
{
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId=0;
    /**
     * Akan mengembalikan bonus database sehingga returnnya BONUS DATABASE
     * @return BONUS_DATABASE
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
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
    * Akan mengembalikan bonus berdasarkan id sehingga returnnya null
    * @return null
    */
    public static Bonus getBonusById(int id)
    {
        Bonus b1=null;
        for(Bonus b : BONUS_DATABASE){
            if(b.getId()==id){
                b1 = b;
            }
            else {
                return null;
            }
        }
        return b1;
    }
    /**
     * Akan mengembalikan bonus berdasarkan referral code sehingga returnnya null
     * @return null
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Bonus b1=null;
        for(Bonus b : BONUS_DATABASE){
            if(b.getReferralCode()==referralCode){
                b1 = b;
            }
            else {
                return null;
            }
        }
        return b1;
    }
    /**
     * Akan menambah bonus sehingga parameternya bonus
     * @param bonus
     */
    public static boolean addBonus(Bonus bonus)
    {

        for (int i=0;i<BONUS_DATABASE.size();i++){
            if(BONUS_DATABASE.get(i).getReferralCode() == bonus.getReferralCode()){
                return false;
            }
        }

        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }
    /**
     * Akan menghapus bonus sehingga parameternya bonus
     * @param id
     */
    public static boolean activeBonus(int id)
    {
        boolean bo = false;
        for(Bonus b : BONUS_DATABASE){
            if(b.getId()==id){
                b.setActive(true);
                bo = true;
            }
        }
        return bo;
    }
    /**
     * Akan menghapus bonus sehingga parameternya bonus
     * @param id
     */
    public static boolean deactivateBonus(int id)
    {
        boolean bo = false;
        for(Bonus b : BONUS_DATABASE){
            if(b.getId()==id){
                b.setActive(true);
                bo = true;
            }
        }
        return bo;
    }
   /**
     * Akan menghapus bonus sehingga parameternya bonus
     * @param id
     */
    public static boolean removeBonus(int id)
    {
        boolean b1 = false;
        for(Bonus b : BONUS_DATABASE){
            if(b.getId() == id){
                BONUS_DATABASE.remove(b);
                b1 = true;
            }
        }

        return b1;
    }

}
