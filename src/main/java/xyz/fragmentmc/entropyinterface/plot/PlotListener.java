package xyz.fragmentmc.entropyinterface.plot;

import com.plotsquared.core.PlotAPI;

public class PlotListener {
    public PlotListener(PlotAPI api) {
        api.registerListener(this);
    }
}
