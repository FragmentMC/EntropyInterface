package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TntFlowFlag extends EntropyBooleanFlag<TntFlowFlag> {
    public TntFlowFlag(boolean value) {
        super("Enable or disable tnt waterflow on your plot.", value, false);
    }

    public TntFlowFlag() {
        this(false);
    }

    @Override
    protected EntropyBooleanFlag<TntFlowFlag> flagOf(@NonNull Boolean value) {
        return new TntFlowFlag(value);
    }
}
