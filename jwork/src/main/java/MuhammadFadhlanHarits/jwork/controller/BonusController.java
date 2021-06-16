/**
 * @author Muhammad Fadhlan Harits
 * @version 20 Mei 2021
 */
package MuhammadFadhlanHarits.jwork.controller;

import MuhammadFadhlanHarits.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController

public class BonusController
{
    /**
     * Akan mengembalikan database bonus sehingga returnnya getBonusDatabase
     * @return getBonusDatabase
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus()
    {
        return DatabaseBonus.getBonusDatabase();
    }

    /**
     * Akan mengembalikan bonus berdasarkan referral code sehingga returnnya bonus
     * @return b1
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable String referralCode)
    {
        Bonus b1 = DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
        return b1;
    }
    /**
     * Akan menambah bonus sehingga returnnya bonus
     * @return bonus
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                      @RequestParam(value="extraFee") int extraFee,
                      @RequestParam(value="minTotalFee") int minTotalFee,
                      @RequestParam(value = "active") boolean active) throws ReferralCodeAlreadyExistsException
    {
        Bonus bonus = null;
        try {
            bonus = new Bonus(DatabaseBonus.getLastId()+1, referralCode, extraFee, minTotalFee, active);
            DatabaseBonusPostgre.insertBonus(bonus);
        } catch (ReferralCodeAlreadyExistsException e) {
            e.getMessage();
        }
        return bonus;
    }
}
