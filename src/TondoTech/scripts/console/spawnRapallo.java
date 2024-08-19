package TondoTech.scripts.console;

import TondoTech.scripts.campaign.systemGen.RapalloContainmentZone;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import org.jetbrains.annotations.NotNull;
import org.lazywizard.console.BaseCommand;
import org.lazywizard.console.Console;


import java.util.Map;

public class spawnRapallo implements BaseCommand {
    @Override
    public CommandResult runCommand(@NotNull String s, @NotNull BaseCommand.CommandContext commandContext) {
        CommandResult commandResult=CommandResult.ERROR;
        Map<String, Object> data = Global.getSector().getPersistentData();
        if (!data.containsKey("tondoTech_rapalloGenerated")) {

            SectorAPI sector = Global.getSector();
            RapalloContainmentZone.generate(sector);
            commandResult = CommandResult.SUCCESS;
        }
        else{
            Console.showMessage("TondoTech attempted to generate Rapalllo star system, but Rapello already exists. Generation aborted.");
        }

        return commandResult;

    }
}
