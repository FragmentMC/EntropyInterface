package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import xyz.fragmentmc.entropy.event.TntFlowEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.TntFlowFlag;

@CommandData(name = "tntflow", message = "TNT Waterflow")
public class TntFlowCommand extends ToggleCommand implements Listener {
    public TntFlowCommand() {
        super(TntFlowFlag.class);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onTntFlow(TntFlowEvent event) {
        event.setCancelled(!PlotHelper.getPlotBooleanFlag(flag, event.getTntEntity().getLocation()));
    }
}
