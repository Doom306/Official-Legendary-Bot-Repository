package com.doom.commands.commands.ReactionRolePrivate;

import com.doom.Config;
import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.ReactionRole.ReactionRoleData;

public class ReactionRolePrivateCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getMessage().getMentionedRoles().isEmpty()) {
            ctx.getChannel().sendMessage("Kindly mention a role!!").queue();
            return;
        }

        if (!ctx.getAuthor().getId().equals(Config.get("owner_id")) || !ctx.getAuthor().getId().equals(Config.get("owner_id"))) {
            ctx.getChannel().sendMessage("Do I know you????").queue();
            return;
        }

        if (ctx.getMessage().getMentionedChannels().isEmpty()) {
            ctx.getChannel().sendMessage("Kindly mention a channel!!").queue();
            return;
        }

        ctx.getMessage().getMentionedChannels().get(0).sendMessage("React here to get verified!!!").queue((message -> {
            ReactionRoleData.messages.add(message.getIdLong());
            ReactionRoleData.roles.put(message.getIdLong(), ctx.getMessage().getMentionedRoles().get(0));
            message.addReaction("✅").queue();
        }));

        ctx.getAuthor().openPrivateChannel().queue(
                (PrivateChannel) -> PrivateChannel.sendMessage("Successful!!! The user will now receive the role of " + ctx.getMessage().getMentionedRoles().get(0).getName() + " once they react to the message.").queue()
        );
    }

    @Override
    public String getName() {
        return "verify";
    }

    @Override
    public String getHelp() {
        return "Make a reaction role message";
    }
}
