package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import xyz.fragmentmc.entropy.event.ExplodeLavaEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.ExplodeLavaFlag;

import java.net.http.WebSocket;

@CommandData(name = "explodelava", message = "Explodable Lava")
public class ExplodeLavaCommand extends ToggleCommand implements WebSocket.Listener {
    public ExplodeLavaCommand() {
        super(ExplodeLavaFlag.class);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onExplodeLava(ExplodeLavaEvent event) {
        event.setCancelled(!PlotHelper.getPlotBooleanFlag(ExplodeLavaFlag.class, event.getLocation()));
    }
}
