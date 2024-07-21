package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.shared.SharedData;
import data.scripts.campaign.systemGen.RapalloContainmentZone;
import org.magiclib.util.MagicSettings;

import java.util.Map;

//nuclear's thoughts on org - should probably arrange campaign-level functions by location in the plot outline. initial gen in introductions, discovery in a discovery chapter, and then other shit in further chapters

public class TondoTechModPlugin extends BaseModPlugin {

    private static org.apache.log4j.Logger log = Global.getLogger(TondoTechModPlugin.class);

    public void onApplicationLoad() {
        Global.getSettings().resetCached();
    }
    @Override
    public void onNewGame() {
        //handling campaign setup in onNewGame is for cowards
    }


    @Override
    public void onGameLoad(boolean wasEnabledBefore) {
        Map<String, Object> data = Global.getSector().getPersistentData();
        boolean loadIntoExistingSave= MagicSettings.getBoolean("TondoTech","loadIntoExistingSave");
        if(loadIntoExistingSave) {
            if(!data.containsKey("TondoTech_generated"))
            {
                campaignSetup();
                data.put("TondoTech_generated", "version 0.0.0");
            }
        }
    }

    //im way too tired, I'll refactor around the locations of initialization later
    void campaignSetup(){
        SectorAPI sector=Global.getSector();

        relationshipSetter(sector);
        //maybe have one terrain generator and story setup class


    }

    void relationshipSetter(SectorAPI sector){
        //set all the relations
        SharedData.getData().getPersonBountyEventData().addParticipatingFaction("silverBulletInstitute");

//        FactionAPI silverBulletInstitute = sector.getFaction("silverBulletInstitute");
//        FactionAPI player = sector.getFaction(Factions.PLAYER);
//        FactionAPI hegemony = sector.getFaction(Factions.HEGEMONY);
//        FactionAPI tritachyon = sector.getFaction(Factions.TRITACHYON);
//        FactionAPI pirates = sector.getFaction(Factions.PIRATES);
//        FactionAPI independent = sector.getFaction(Factions.INDEPENDENT);
//        FactionAPI church = sector.getFaction(Factions.LUDDIC_CHURCH);
//        FactionAPI path = sector.getFaction(Factions.LUDDIC_PATH);
//        FactionAPI diktat = sector.getFaction(Factions.DIKTAT);
//        FactionAPI kol = sector.getFaction(Factions.KOL);
//        FactionAPI persean = sector.getFaction(Factions.PERSEAN);
//        FactionAPI guard = sector.getFaction(Factions.LIONS_GUARD);
//        FactionAPI remnant = sector.getFaction(Factions.REMNANTS);
//        FactionAPI derelict = sector.getFaction(Factions.DERELICT);

//        //vanilla factions
//        silverBulletInstitute.setRelationship(hegemony.getId(), -1.0f);
//        silverBulletInstitute.setRelationship(player.getId(), 0);
//        silverBulletInstitute.setRelationship(pirates.getId(), -0.5f);
//
//        silverBulletInstitute.setRelationship(independent.getId(), 0.5f);
//
//        silverBulletInstitute.setRelationship(tritachyon.getId(), 0.5f);
//
//        silverBulletInstitute.setRelationship(kol.getId(), -0.5f);
//        silverBulletInstitute.setRelationship(path.getId(), -0.75f);
//        silverBulletInstitute.setRelationship(church.getId(), -0.75f);
//
//        silverBulletInstitute.setRelationship(persean.getId(), 0.25f);
//        silverBulletInstitute.setRelationship(guard.getId(), 0.25f);
//        silverBulletInstitute.setRelationship(diktat.getId(), 0.25f);
//
//
//        //environment
//        silverBulletInstitute.setRelationship(remnant.getId(), RepLevel.COOPERATIVE);
//        silverBulletInstitute.setRelationship(derelict.getId(), RepLevel.COOPERATIVE);
//
//        // mod factions
//        silverBulletInstitute.setRelationship("vic", 0f);
//        silverBulletInstitute.setRelationship("ironsentinel", -0.49f);
//        silverBulletInstitute.setRelationship("ironshell", -0.49f);
//
//        silverBulletInstitute.setRelationship("sylphon", -0.4f);
//        silverBulletInstitute.setRelationship("Coalition", -0.3f);
//        silverBulletInstitute.setRelationship("tiandong", 0f);
//        silverBulletInstitute.setRelationship("kadur_remnant", 0f);
//        silverBulletInstitute.setRelationship("blackrock_driveyards", 0.25f);
//        silverBulletInstitute.setRelationship("interstellarimperium", 0.25f);
//        silverBulletInstitute.setRelationship("HMI", 0.5f);
//        silverBulletInstitute.setRelationship("al_ars", -0.25f);
//        silverBulletInstitute.setRelationship("mayorate", -0.25f);
//        silverBulletInstitute.setRelationship("SCY", 0.25f);
//        silverBulletInstitute.setRelationship("blade_breakers", -0.5f);
//        silverBulletInstitute.setRelationship("dassault_mikoyan", 0f);
//        silverBulletInstitute.setRelationship("diableavionics", -0.5f);
//        silverBulletInstitute.setRelationship("ORA", 0.25f);
//        silverBulletInstitute.setRelationship("gmda", -0.25f);
//        silverBulletInstitute.setRelationship("gmda_patrol", -0.25f);
//
//        silverBulletInstitute.setRelationship("tahlan_legioinfernalis", -0.15f);
//        silverBulletInstitute.setRelationship("yrxp", 0f);
//
//        silverBulletInstitute.setRelationship("cabal", -0.5f);
//
//        // the below are just copied from xhan, but might be fine?
//        silverBulletInstitute.setRelationship("shadow_industry", -0.6f);
//        silverBulletInstitute.setRelationship("roider", -0.6f);
//        silverBulletInstitute.setRelationship("exipirated", -0.6f);
//        silverBulletInstitute.setRelationship("draco", -0.6f);
//        silverBulletInstitute.setRelationship("fang", -0.6f);
//        silverBulletInstitute.setRelationship("junk_pirates", -0.6f);
//        silverBulletInstitute.setRelationship("junk_pirates_hounds", -0.6f);
//        silverBulletInstitute.setRelationship("junk_pirates_junkboys", -0.6f);
//        silverBulletInstitute.setRelationship("junk_pirates_technicians", -0.6f);
//        silverBulletInstitute.setRelationship("the_cartel", -0.6f);
//        silverBulletInstitute.setRelationship("nullorder", -0.6f);
//        silverBulletInstitute.setRelationship("templars", -0.6f);
//        silverBulletInstitute.setRelationship("crystanite_pir", -0.6f);
//        silverBulletInstitute.setRelationship("infected", -0.6f);
//        silverBulletInstitute.setRelationship("new_galactic_order", -0.6f);
//        silverBulletInstitute.setRelationship("TF7070_D3C4", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_1", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_2", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_3", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_4", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_5", -0.6f);
//        silverBulletInstitute.setRelationship("minor_pirate_6", -0.6f);

    }
}