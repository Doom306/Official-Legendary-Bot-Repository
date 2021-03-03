package com.doom.commands.commands.Info;

import com.doom.Config;
import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Others.BadDesign;
import com.doom.database.DatabaseManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;

import java.awt.*;
import java.util.List;

public class AboutCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) throws InterruptedException {
        JDA jda = ctx.getJDA();
        List<Guild> list = jda.getGuilds();
        final int size = jda.getTextChannels().size();
        final int voice = jda.getVoiceChannels().size();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        String prefix = BadDesign.PREFIXES.computeIfAbsent(ctx.getGuild().getIdLong(), DatabaseManager.INSTANCE::getPrefix);

        embedBuilder.setTitle("About " + ctx.getSelfUser().getName() + "!");
        embedBuilder.setColor(Color.cyan);
        embedBuilder.addField("Hello! I am " + ctx.getSelfUser().getName() + ", a moderation bot that is easy to use!\n" +
                "(v5.0.2)\n" +
                "I am owned and programmed by " + ctx.getJDA().retrieveUserById(Config.get("owner_id")).complete().getName() +
                " using `Java` and the `JDA library` (v.4.2.0_277)\n" +
                "Type `" + prefix + "help` to see my commands!\n", "", false);
        embedBuilder.addField("Stats", "Ping: " + jda.getGatewayPing() + "\n" +
                list.size() + " Servers", false);

        embedBuilder.addField("Other info", "Text Channels: " + size + "\n" +
                "Voice Channels: " + voice, false);
        embedBuilder.setFooter("Last restart --- Yesterday at 8:00");
        ctx.getChannel().sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getHelp() {
        return "Shows information about the bot!";
    }
}
