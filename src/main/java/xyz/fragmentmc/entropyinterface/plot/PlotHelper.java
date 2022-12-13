package xyz.fragmentmc.entropyinterface.plot;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.database.DBFunc;
import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import com.plotsquared.core.plot.PlotArea;
import com.plotsquared.core.plot.flag.PlotFlag;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.fragmentmc.entropyinterface.plot.flags.EntropyBooleanFlag;
import xyz.fragmentmc.entropyinterface.plot.flags.EntropyIntFlag;

import java.lang.reflect.InvocationTargetException;

public class PlotHelper {
    private static final PlotAPI plotAPI = new PlotAPI();

    public static PlotAPI getPlotAPI() {
        return plotAPI;
    }

    private static <T> T getPlotFlag(Class<? extends PlotFlag<T, ?>> flag, org.bukkit.Location location) {
        Location loc = PlotInterface.location(location);
        PlotArea area = plotAPI.getPlotSquared().getPlotAreaManager().getPlotArea(loc);
        if (area != null) {
            Plot plot = area.getPlot(loc);
            if (plot != null) return plot.getFlag(flag);
        }
        return null;
    }

    public static boolean getPlotBooleanFlag(Class<? extends EntropyBooleanFlag<?>> flag, org.bukkit.Location location) {
        Boolean f = getPlotFlag(flag, location);
        if (f != null) return f;
        try {
            return flag.getConstructor().newInstance().defaultValue;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getPlotIntFlag(Class<? extends EntropyIntFlag<?>> flag, org.bukkit.Location location) {
        Integer f = getPlotFlag(flag, location);
        if (f != null) return f;
        try {
            return flag.getConstructor().newInstance().defaultValue;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Boolean togglePlotBooleanFlag(Class<? extends EntropyBooleanFlag<?>> flag, org.bukkit.Location location, Player player) {
        Location loc = PlotInterface.location(location);
        PlotArea plotArea = plotAPI.getPlotSquared().getPlotAreaManager().getPlotArea(loc);
        if (plotArea != null) {
            Plot plot = plotArea.getPlot(loc);
            if (plot != null && isPlayerTrusted(player, plot)) {
                boolean newFlag = !plot.getFlag(flag);
                try {
                    EntropyBooleanFlag<?> f = flag.getConstructor(boolean.class).newInstance(newFlag);
                    plot.getFlagContainer().addFlag(f);
                    DBFunc.setFlag(plot, f);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return newFlag;
            }
        }
        return null;
    }

    public static boolean setPlotIntFlag(Class<? extends EntropyIntFlag<?>> flag, org.bukkit.Location location, Player player, int value) {
        Location loc = PlotInterface.location(location);
        PlotArea plotArea = plotAPI.getPlotSquared().getPlotAreaManager().getPlotArea(loc);
        if (plotArea != null) {
            Plot plot = plotArea.getPlot(loc);
            if (plot != null && isPlayerTrusted(player, plot)) {
                EntropyIntFlag<?> f = null;
                try {
                    f = flag.getConstructor(int.class).newInstance(value);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                plot.getFlagContainer().addFlag(f);
                DBFunc.setFlag(plot, f);
                return true;
            }
        }
        return false;
    }

    public static boolean isPlayerTrusted(Player player, @NotNull Plot plot) {
        return plot.isAdded(player.getUniqueId()) || plot.isOwner(player.getUniqueId());
    }
}
