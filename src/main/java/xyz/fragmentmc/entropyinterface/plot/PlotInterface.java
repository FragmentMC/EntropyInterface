package xyz.fragmentmc.entropyinterface.plot;

import com.plotsquared.core.location.Location;

public class PlotInterface {
    public static Location location(org.bukkit.Location location) {
        return Location.at(location.getWorld().getName(), location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }
}
