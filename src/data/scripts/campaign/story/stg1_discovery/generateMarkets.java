package data.scripts.campaign.story.stg1_discovery;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import data.scripts.campaign.systemGen.RapalloContainmentZone;

public class generateMarkets {
    generateMarkets(){
        SectorAPI sector= Global.getSector();
        FactionAPI silverBulletInstitute=sector.getFaction("silverBulletInstitute");
        silverBulletInstitute.setShowInIntelTab(true);
        RapalloContainmentZone.generate(sector);

        generateCharacter1();
        generateCharacter2();
    }

    void generateCharacter1(){

    }
    void generateCharacter2(){

    }
}
