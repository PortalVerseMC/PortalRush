package com.bloobon.portalrush.portalrush.commands;

import com.bloobon.portalrush.portalrush.PortalRush;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PortalRushCommand implements CommandExecutor {

    private final Set<SubCommand> commands = new HashSet<>();
    private final @NotNull PortalRush portalRush;

    public PortalRushCommand(@NotNull PortalRush portalRush){
        this.portalRush = portalRush;
        setup();
    }

    private void setup(){
        commands.add(new SetupIslandCommand(portalRush));
        Objects.requireNonNull(portalRush.getCommand("admin")).setExecutor(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player){
            if(!player.isOp()) return false;
            if(strings.length == 0){
                    invalidSubcommand(player);
            } else {
                Optional<SubCommand> target = this.getSubcommand(strings[0]);
                target.ifPresentOrElse(
                        taropt -> {
                            taropt.onCommand(player, (String[]) Arrays.stream(strings).skip(1).toArray());
                        }
                        , () -> invalidSubcommand(player));
            }
        }
        return false;
    }

    private void invalidSubcommand(@NotNull Player player){
            commands.forEach(cmd -> player.sendMessage("/admin " + cmd.getName()));}

    private Optional<SubCommand> getSubcommand(@NotNull String name){
        for (SubCommand sc : commands) {
            if (sc.getName().equalsIgnoreCase(name)) return Optional.of(sc);
            String[] aliases = sc.getAliases();
            for (String alias : aliases) {
                if (name.equalsIgnoreCase(alias)) return Optional.of(sc);
            }
        }
        return Optional.empty();
    }
}

