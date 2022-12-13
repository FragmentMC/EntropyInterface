package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class FallingBlockParityFlag extends EntropyBooleanFlag<FallingBlockParityFlag> {
    public FallingBlockParityFlag(boolean value) {
        super("Enable or disable falling block parity on your plot.", value, false);
    }

    public FallingBlockParityFlag() {
        this(false);
    }

    @Override
    protected EntropyBooleanFlag<FallingBlockParityFlag> flagOf(@NonNull Boolean value) {
        return new FallingBlockParityFlag(value);
    }
}
