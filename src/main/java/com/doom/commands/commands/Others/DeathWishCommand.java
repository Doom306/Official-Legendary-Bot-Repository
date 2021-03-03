package com.doom.commands.commands.Others;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.EmbedBuilder;

public class DeathWishCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getMessage().getMentionedMembers().isEmpty()) {
            ctx.getChannel().sendMessage(getHelp()).queue();
            return;
        }
        if (ctx.getArgs().isEmpty()) {
            ctx.getChannel().sendMessage(getHelp()).queue();
        } else {
            String state = ctx.getArgs().get(0);

            if (state.equals(ctx.getMessage().getMentionedMembers().get(0).getAsMention())) {
                state = ctx.getArgs().get(1);
            }

            String stuff = String.format(("%s died due to %s"), ctx.getMessage().getMentionedMembers().get(0).getAsMention(), state);
            EmbedBuilder embed = EmbedUtils.defaultEmbed()
                    .setThumbnail("https://img1.looper.com/img/gallery/ryuk-in-netflixs-death-note-had-to-be-played-by-two-actors/intro-1503169693.jpg")
                    .setTitle("DEATH NOTE")
                    .setDescription(stuff)
                    .setFooter(getHelp())
                    .setImage("https://media.comicbook.com/2017/03/screen-shot-2017-03-23-at-2-46-03-pm-240311.png");
            ctx.getChannel().sendMessage(embed.build()).queue();
        }
    }

    @Override
    public String getName() {
        return "death";
    }

    @Override
    public String getHelp() {
        return "The user whose name is written in this note shall have a death wish.\n" +
                "Usage: `/death [mention] [how you will kill him/her]`";
    }
}
