package data.scripts.campaign.systemGen;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.impl.campaign.DerelictShipEntityPlugin;
import com.fs.starfarer.api.impl.campaign.ids.Tags;
import com.fs.starfarer.api.impl.campaign.procgen.themes.BaseThemeGenerator;
import com.fs.starfarer.api.impl.campaign.procgen.themes.SalvageSpecialAssigner;
import com.fs.starfarer.api.impl.campaign.rulecmd.salvage.special.ShipRecoverySpecial;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.WeightedRandomPicker;
import data.scripts.TondoTech_utils;

import java.util.Random;

import static com.fs.starfarer.api.impl.campaign.rulecmd.salvage.special.ShipRecoverySpecial.ShipCondition.WRECKED;

public class PenopStarDerelict {

    //Her voice is silver; her tongue is sweet.

    SectorAPI sector= Global.getSector();
    StarSystemAPI penopStarSys = sector.getStarSystem("penelope's star");

    SectorEntityToken penlopStar=penopStarSys.getStar();
    ShipRecoverySpecial.ShipCondition condition =WRECKED;



    //dummy variant name for now
    //dummy distance from star from now
        //actual loc should be roughly 1972, 915
    SectorEntityToken wreck=TondoTech_utils.addDerelict(penopStarSys, penlopStar,"revenant_Elite", "Blue Spark", "wreck_bluespark",condition, 1000f, true);
    SectorEntityToken radioEffect = penopStarSys.addTerrain("wreckRadio_bluospark", wreck );
    //TODO: set locations, name, and scripts so it actually jolts the plot into action when interacted with

    //something something relic, if you properly establish contact, their world will spawn and they will appear in intel


}



