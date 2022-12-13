package xyz.fragmentmc.entropyinterface.plot.flags;

import com.plotsquared.core.configuration.caption.StaticCaption;
import com.plotsquared.core.plot.flag.InternalFlag;
import com.plotsquared.core.plot.flag.types.BooleanFlag;

public abstract class EntropyBooleanFlag<T extends EntropyBooleanFlag<T>> extends BooleanFlag<EntropyBooleanFlag<T>> implements InternalFlag {
    public final boolean defaultValue;

    protected EntropyBooleanFlag(String desc, boolean value, boolean defaultValue) {
        super(value, StaticCaption.of(desc));
        this.defaultValue = defaultValue;
    }
}
