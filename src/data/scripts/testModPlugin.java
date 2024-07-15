package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.loading.FighterWingSpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import data.scripts.util.MagicSettings;
import data.scripts.utils.seven_util_sysgen;
import data.scripts.world.sevencorpGenEpta;
import data.scripts.world.sevencorpGenTakeshido;
import exerelin.campaign.SectorManager;

import java.util.List;
import java.util.Map;

public class testModPlugin extends BaseModPlugin {

    private static org.apache.log4j.Logger log = Global.getLogger(testModPlugin.class);


    @Override
    public void onNewGame() {

    }


    @Override
    public void onGameLoad(boolean wasEnabledBefore) {

    }
}