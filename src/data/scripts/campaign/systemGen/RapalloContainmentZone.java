package data.scripts.campaign.systemGen;

import com.fs.starfarer.api.campaign.OrbitAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.impl.campaign.ids.Tags;
import org.lazywizard.lazylib.campaign.orbits.EllipticalOrbit;

import java.awt.*;

public class RapalloContainmentZone {

    public static void generate(SectorAPI sector) {

        StarSystemAPI system = sector.createStarSystem("Rapallo Containment Zone");
        system.getLocation().set(-63800, 20000);
        system.setBackgroundTextureFilename("graphics/backgrounds/background2.jpg");
        system.addTag(Tags.THEME_HIDDEN);

        PlanetAPI RCZ_star = system.initStar(
                "TondoTech_RCZ",
                "star_orange", //TODO: set star type properly
                905f,
                701f);

        RCZ_star.setName("The Sunset Core");

        system.addRingBand(RCZ_star, "misc", "rings_dust0", 256f, 0, Color.white, 256f, 2120, 80f);
        system.addRingBand(RCZ_star, "misc", "rings_dust0", 256f, 1, Color.white, 256f, 2320, 100f);
        system.addRingBand(RCZ_star, "misc", "rings_dust0", 256f, 2, Color.white, 256f, 2520, 130f);

        PlanetAPI testPlanet = system.addPlanet("testPlanetID",
                RCZ_star,
                "testPlanet",
                "frozen2",
                140f, //starting angle
                140f, //size
                11000f, // orbit radius
                600f); // orbit time
        //EllipticalOrbit(SectorEntityToken focus, float startAngle, float orbitWidth, float orbitHeight, float orbitAngle, float daysPerOrbit)
        OrbitAPI IncFrezOrbit= new EllipticalOrbit(RCZ_star, 0, 6400, 15000f, 60, 365f);
        testPlanet.setOrbit(IncFrezOrbit);

    }
}
