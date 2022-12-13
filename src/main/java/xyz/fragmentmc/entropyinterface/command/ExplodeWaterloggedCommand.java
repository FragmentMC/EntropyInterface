package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import xyz.fragmentmc.entropy.event.ExplodeWaterloggedEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.ExplodeWaterloggedFlag;

@CommandData(name = "explodewaterlogged", message = "Explodable Waterlogged Blocks")
public class ExplodeWaterloggedCommand extends ToggleCommand implements Listener {
    public ExplodeWaterloggedCommand() {
        super(ExplodeWaterloggedFlag.class);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onExplodeWaterlogged(ExplodeWaterloggedEvent event) {
        event.setCancelled(!PlotHelper.getPlotBooleanFlag(ExplodeWaterloggedFlag.class, event.getLocation()));
    }
}
