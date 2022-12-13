package xyz.fragmentmc.entropyinterface;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import xyz.fragmentmc.entropyinterface.command.*;

public class Features {
    private static EntropyInterface pluginInstance;

    public static void init(EntropyInterface instance) {
        pluginInstance = instance;
        register();
    }

    private static void register() {
        addCommandsAndEvents(
                new TntSpreadCommand(),
                new TntFlowCommand(),
                new ExplodeLavaCommand(),
                new ExplodeWaterloggedCommand(),
                new FallingBlockParityCommand(),
                new ObsidianDurabilityCommand());
    }

    @SuppressWarnings("ConstantConditions")
    private static void addCommandsAndEvents(Object... features) {
        PluginManager pm = pluginInstance.getServer().getPluginManager();
        for (Object f : features) {
            if (f instanceof BaseCommand c) pluginInstance.getCommand(c.getName()).setExecutor(c);
            if (f instanceof Listener l) pm.registerEvents(l, pluginInstance);
        }
    }
}
