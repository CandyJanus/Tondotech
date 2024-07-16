package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import data.scripts.campaign.systemGen.RapalloContainmentZone;
import org.magiclib.util.MagicSettings;

import java.util.Map;

public class TendoTechModPlugin extends BaseModPlugin {

    private static org.apache.log4j.Logger log = Global.getLogger(TendoTechModPlugin.class);

    public void onApplicationLoad() {
        Global.getSettings().resetCached();
    }
    @Override
    public void onNewGame() {
        Map<String, Object> data = Global.getSector().getPersistentData();
        campaignSetup();
        data.put("TondoTech_generated", "version 0.0.0");
    }


    @Override
    public void onGameLoad(boolean wasEnabledBefore) {
        Map<String, Object> data = Global.getSector().getPersistentData();
        boolean loadIntoExistingSave= MagicSettings.getBoolean("TondoTech","loadIntoExistingSave");
        if(loadIntoExistingSave) {
            campaignSetup();
           data.put("TondoTech_generated", "version 0.0.0");
        }
    }

    void campaignSetup(){
        SectorAPI sector=Global.getSector();
        RapalloContainmentZone.generate(sector);
    }
}