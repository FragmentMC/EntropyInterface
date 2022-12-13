package xyz.fragmentmc.entropyinterface.plot.flags;

import com.plotsquared.core.plot.flag.GlobalFlagContainer;

import java.util.Arrays;

public class FlagManager {
    private static GlobalFlagContainer flagContainer;

    public static void init() {
        flagContainer = GlobalFlagContainer.getInstance();
        registerFlags();
    }

    private static void registerFlags() {
        registerBoolean(
                new TntSpreadFlag(),
                new TntFlowFlag(),
                new FallingBlockParityFlag(),
                new ExplodeWaterloggedFlag(),
                new ExplodeLavaFlag());
        registerInt(
                new ObsidianDurabilityFlag());
    }

    private static void registerBoolean(EntropyBooleanFlag<?>... flags) {
        flagContainer.addAll(Arrays.asList(flags));
    }

    private static void registerInt(EntropyIntFlag<?>... flags) {
        flagContainer.addAll(Arrays.asList(flags));
    }
}
