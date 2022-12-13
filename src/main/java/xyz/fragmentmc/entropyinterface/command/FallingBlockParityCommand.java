package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import xyz.fragmentmc.entropy.event.DetermineFallingBlockExposureEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.FallingBlockParityFlag;

@CommandData(name = "fallingblockparity", message = "Falling Block Parity")
public class FallingBlockParityCommand extends ToggleCommand implements Listener {
    public FallingBlockParityCommand() {
        super(FallingBlockParityFlag.class);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDetermineFallingBlockExposure(DetermineFallingBlockExposureEvent event) {
        event.setCancelled(!PlotHelper.getPlotBooleanFlag(FallingBlockParityFlag.class, event.getLocation()));
    }
}
