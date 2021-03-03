package com.doom.commands.commands.ReactionRole;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import net.dv8tion.jda.api.Permission;

public class ReactionRoleCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getMessage().getMentionedRoles().isEmpty()) {
            ctx.getChannel().sendMessage("Kindly mention a role!!").queue();
            return;
        }

        if (ctx.getMessage().getMentionedChannels().isEmpty()) {
            ctx.getChannel().sendMessage("Kindly mention a channel!!").queue();
            return;
        }

        if (!ctx.getMember().hasPermission(Permission.MANAGE_ROLES)) {
            ctx.getChannel().sendMessage("Unsuccessful!!! You do not has the `Manage Roles` permission.").queue();
            return;
        }

        ctx.getMessage().getMentionedChannels().get(0).sendMessage("React here to get the role of " + ctx.getMessage().getMentionedRoles().get(0).getAsMention()).queue((message -> {
            ReactionRoleData.messages.add(message.getIdLong());
            ReactionRoleData.roles.put(message.getIdLong(), ctx.getMessage().getMentionedRoles().get(0));
            message.addReaction("\uD83E\uDE99").queue();
        }));

        ctx.getAuthor().openPrivateChannel().queue(
                (PrivateChannel) -> PrivateChannel.sendMessage("Successful!!! The user will now receive the role of " + ctx.getMessage().getMentionedRoles().get(0).getName() + " once they react to the message.").queue()
        );
    }

    @Override
    public String getName() {
        return "reactrole";
    }

    @Override
    public String getHelp() {
        return "Make a reaction role message";
    }
}
