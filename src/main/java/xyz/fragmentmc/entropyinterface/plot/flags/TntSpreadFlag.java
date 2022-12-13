package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TntSpreadFlag extends EntropyBooleanFlag<TntSpreadFlag> {
    public TntSpreadFlag(boolean value) {
        super("Enable or disable tnt spread on your plot.", value, false);
    }

    public TntSpreadFlag() {
        this(false);
    }

    @Override
    protected EntropyBooleanFlag<TntSpreadFlag> flagOf(@NonNull Boolean value) {
        return new TntSpreadFlag(value);
    }
}
