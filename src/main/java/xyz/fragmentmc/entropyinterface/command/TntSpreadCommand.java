package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import xyz.fragmentmc.entropy.event.TntSpreadEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.TntSpreadFlag;

@CommandData(name = "tntspread", message = "TNT Spread")
public class TntSpreadCommand extends ToggleCommand implements Listener {
    public TntSpreadCommand() {
        super(TntSpreadFlag.class);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTntSpread(TntSpreadEvent event) {
        event.setCancelled(!PlotHelper.getPlotBooleanFlag(flag, event.getTntEntity().getLocation()));
    }
}
