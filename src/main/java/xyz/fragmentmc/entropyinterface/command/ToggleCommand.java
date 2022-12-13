package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.EntropyBooleanFlag;

public abstract class ToggleCommand extends BaseCommand {
    protected final Class<? extends EntropyBooleanFlag<?>> flag;

    protected ToggleCommand(Class<? extends EntropyBooleanFlag<?>> flag) {
        this.flag = flag;
    }

    private String stateWithColor(boolean color) {
        return (color ? "&a" + "on" : "&c" + "off") + "&7";
    }

    protected String toggleMessage(boolean toggle) {
        return "&7Turned " + commandData.message() + " " + stateWithColor(toggle) + ".";
    }

    @Override
    String doCommand(@NotNull Player player, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Boolean state = PlotHelper.togglePlotBooleanFlag(flag, player.getLocation(), player);
        if (state != null) {
            return toggleMessage(state);
        } else {
            return ERROR;
        }
    }
}
