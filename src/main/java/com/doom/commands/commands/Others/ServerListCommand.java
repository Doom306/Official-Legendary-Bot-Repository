package com.doom.commands.commands.Others;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import java.util.List;
import java.util.Objects;

public class ServerListCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        List<Guild> list = jda.getGuilds();
        int i = 0;

        while (i < (list.size())) {
            String url = Objects.requireNonNull(list.get(i).getDefaultChannel()).createInvite().complete().getUrl();
            int finalI = i;
            ctx.getAuthor().openPrivateChannel().queue(
                    (PrivateChannel) ->
                            PrivateChannel.sendMessage("Invite for " + list.get(finalI).getName() + " is " + url).queue()
            );
            ctx.getChannel().sendMessage("This bot is in " + list.get(i).getName() + " Main Channel is `" + Objects.requireNonNull(list.get(i).getDefaultChannel()).getName() + "`").queue();
            i++;
        }
    }

    @Override
    public String getName() {
        return "serverlist";
    }

    @Override
    public String getHelp() {
        return "Usage: `/serverlist`\n" +
                "Displays the name of servers the bot is in.";
    }
}
