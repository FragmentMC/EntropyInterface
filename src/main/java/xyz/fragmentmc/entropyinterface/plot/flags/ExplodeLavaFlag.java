package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class ExplodeLavaFlag extends EntropyBooleanFlag<ExplodeLavaFlag> {
    public ExplodeLavaFlag(boolean value) {
        super("Enable or disable lava blowing up on your plot.", value, false);
    }

    public ExplodeLavaFlag() {
        this(false);
    }

    @Override
    protected EntropyBooleanFlag<ExplodeLavaFlag> flagOf(@NonNull Boolean value) {
        return new ExplodeLavaFlag(value);
    }
}
