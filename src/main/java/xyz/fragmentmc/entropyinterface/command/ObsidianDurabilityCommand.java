package xyz.fragmentmc.entropyinterface.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.fragmentmc.entropy.event.AssignDurabilityEvent;
import xyz.fragmentmc.entropyinterface.plot.PlotHelper;
import xyz.fragmentmc.entropyinterface.plot.flags.ObsidianDurabilityFlag;

import java.util.ArrayList;
import java.util.List;

@CommandData(name = "obsidiandurability")
public class ObsidianDurabilityCommand extends BaseCommand implements Listener, TabCompleter {
    @Override
    String doCommand(@NotNull Player player, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length < 1) return INVALID;
        int durability;
        try {
            durability = Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            return INVALID;
        }
        if (durability < 1 || durability > 25) return INVALID;
        boolean state = PlotHelper.setPlotIntFlag(ObsidianDurabilityFlag.class, player.getLocation(), player, durability);
        if (state) {
            return "&7Set obsidian durability to &a" + durability + "&7.";
        } else {
            return ERROR;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> list = new ArrayList<>();
        if (strings.length == 1) list.addAll(List.of("1", "3", "5", "10", "25"));
        return list;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onAssignDurability(AssignDurabilityEvent event) {
        if (event.getMaterial() == Material.OBSIDIAN)
            event.setDurability(PlotHelper.getPlotIntFlag(ObsidianDurabilityFlag.class, event.getLocation()));
    }
}
