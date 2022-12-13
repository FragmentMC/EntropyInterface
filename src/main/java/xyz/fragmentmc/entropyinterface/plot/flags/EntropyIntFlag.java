package xyz.fragmentmc.entropyinterface.plot.flags;

import com.plotsquared.core.configuration.caption.StaticCaption;
import com.plotsquared.core.plot.flag.InternalFlag;
import com.plotsquared.core.plot.flag.types.IntegerFlag;

public abstract class EntropyIntFlag<T extends EntropyIntFlag<T>> extends IntegerFlag<EntropyIntFlag<T>> implements InternalFlag {
    public final int defaultValue;

    protected EntropyIntFlag(String desc, int value, int min, int max, int defaultValue) {
        super(value, min, max, StaticCaption.of(desc));
        this.defaultValue = defaultValue;
    }
}
