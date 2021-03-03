package com.doom.commands.commands.admin;

import com.doom.Config;
import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Others.BadDesign;
import com.doom.database.DatabaseManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class SetPrefixCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final List<String> args = ctx.getArgs();
        final Member member = ctx.getMember();

        if (!member.hasPermission(Permission.MANAGE_SERVER) && !member.getId().equals(Config.get("owner_id"))) {
            channel.sendMessage("You must have the Manage Server permission to use his command").queue();
            return;
        }

        long guildId = ctx.getGuild().getIdLong();

        if (member.getId().equals(Config.get("owner_id")) || member.getId().equals(Config.get("owner_id_partner"))) {
            try {
                if (!ctx.getArgs().get(1).isEmpty()) {
                    guildId = Long.getLong(ctx.getArgs().get(1));
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        if (args.isEmpty()) {
            channel.sendMessage("Missing args").queue();
            return;
        }

        final String newPrefix = String.join("", args);
        updatePrefix(guildId, newPrefix);

        channel.sendMessageFormat("New prefix has been set to `%s` for `%s`", newPrefix, ctx.getJDA().getGuildById(guildId).getName()).queue();
    }

    @Override
    public String getName() {
        return "setprefix";
    }

    @Override
    public String getHelp() {
        return "Sets the prefix for this server\n" +
                "Usage: '/setprefix <prefix>'";
    }

    private void updatePrefix(long guildId, String newPrefix) {
        BadDesign.PREFIXES.put(guildId, newPrefix);
        DatabaseManager.INSTANCE.setPrefix(guildId, newPrefix);
    }
}
