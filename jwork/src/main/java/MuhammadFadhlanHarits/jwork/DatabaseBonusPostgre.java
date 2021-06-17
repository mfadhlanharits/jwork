package MuhammadFadhlanHarits.jwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseBonusPostgre extends DatabaseConnectionPostgre
{
    private static ArrayList<Bonus> DATABASE_BONUS = new ArrayList<Bonus>();
    private static int lastId;
    /**
     * Akan mengembalikan bonus berdasarkan referral code sehingga returnnya bonus
     * @return null
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Connection c = connection();
        PreparedStatement st;
        Bonus b1=null;
        int id=0;
        String code = null;
        int extraFee=0;
        int minTotalFee=0;
        boolean active = false;
        try {
            String query = "SELECT * FROM bonus WHERE referralcode=?;";
            st = c.prepareStatement(query);
            st.setString(1, referralCode);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt("id");
                code = rs.getString("referralcode");
                extraFee = rs.getInt("extrafee");
                minTotalFee = rs.getInt("mintotalfee");
                active = rs.getBoolean("active");
            }
            st.close();
            c.close();
            b1 = new Bonus(id, code, extraFee, minTotalFee, active);
        } catch(SQLException e){
            e.printStackTrace();
        }

        return b1;
    }
    /**
     * Akan menambah bonus sehingga parameternya bonus
     * @param bonus
     */
    public static Bonus insertBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException
    {
        Bonus b1 = null;
        Connection c = connection();
        PreparedStatement st;
        try{
            String query = "INSERT INTO bonus(id, referralcode, extrafee, mintotalfee, active) VALUES(?,?,?,?,?) RETURNING id;";
            st = c.prepareStatement(query);
            st.setInt(1, bonus.getId());
            st.setString(2, bonus.getReferralCode());
            st.setInt(3, bonus.getExtraFee());
            st.setInt(4, bonus.getMinTotalFee());
            st.setBoolean(5, bonus.getActive());
            ResultSet rs = st.executeQuery();
            b1 = new Bonus(DatabaseBonusPostgre.getLastBonusId()+1, bonus.getReferralCode(), bonus.getExtraFee(), bonus.getMinTotalFee(), bonus.getActive());
        } catch(SQLException e){
            e.printStackTrace();
        }

        return b1;
    }

    /**
     * Akan mengembalikan id terakhir sehingga returnnya lastId
     * @return lastId
     */
    public static int getLastBonusId() throws SQLException {
        Connection c = connection();
        PreparedStatement st;
        lastId=0;
        String query = "SELECT id FROM bonus;";
        st = c.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            lastId = rs.getInt(1);
        }
        st.close();
        c.close();

        return lastId;
    }
}
