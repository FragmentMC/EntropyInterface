package xyz.fragmentmc.entropyinterface.command;

import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.apache.logging.log4j.util.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class BaseCommand implements CommandExecutor {
    protected static final String PREFIX = "&7[&6+&7] &r";
    protected static final String ERROR = "&4&lYou are not allowed to do this here!";
    protected static final String INVALID = "&4&lInvalid Argument(s)!";
    protected final CommandData commandData;

    public BaseCommand() {
        commandData = this.getClass().getAnnotation(CommandData.class);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) return true;
        String answer = doCommand((Player) commandSender, command, s, strings);
        if (Strings.isNotEmpty(answer))
            commandSender.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize(PREFIX + answer));
        return true;
    }

    abstract String doCommand(@NotNull Player player, @NotNull Command command, @NotNull String s, @NotNull String[] strings);

    public String getName() {
        return commandData.name();
    }
}
