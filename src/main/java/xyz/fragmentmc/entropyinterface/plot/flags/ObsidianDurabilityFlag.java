package xyz.fragmentmc.entropyinterface.plot.flags;

import org.checkerframework.checker.nullness.qual.NonNull;

public class ObsidianDurabilityFlag extends EntropyIntFlag<ObsidianDurabilityFlag> {
    public ObsidianDurabilityFlag(int value) {
        super("Set the durability of obsidian on your plot.", value, 1, 25, 5);
    }

    public ObsidianDurabilityFlag() {
        this(5);
    }

    @Override
    protected EntropyIntFlag<ObsidianDurabilityFlag> flagOf(@NonNull Integer value) {
        return new ObsidianDurabilityFlag(value);
    }
}
