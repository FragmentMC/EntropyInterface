package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class ExplodeWaterloggedFlag extends EntropyBooleanFlag<ExplodeWaterloggedFlag> {
    public ExplodeWaterloggedFlag(boolean value) {
        super("Enable or disable waterlogged blocks blowing up on your plot.", value, true);
    }

    public ExplodeWaterloggedFlag() {
        this(true);
    }

    @Override
    protected EntropyBooleanFlag<ExplodeWaterloggedFlag> flagOf(@NonNull Boolean value) {
        return new ExplodeWaterloggedFlag(value);
    }
}
