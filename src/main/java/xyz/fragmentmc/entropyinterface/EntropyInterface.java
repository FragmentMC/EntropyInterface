package xyz.fragmentmc.entropyinterface;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.fragmentmc.entropyinterface.plot.flags.FlagManager;

public final class EntropyInterface extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        FlagManager.init();
        Features.init(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
