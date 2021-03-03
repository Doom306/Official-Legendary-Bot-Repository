package com.doom;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Emoji.EmojiCommand;
import com.doom.commands.commands.Fonts.AsciiCommand;
import com.doom.commands.commands.Games.*;
import com.doom.commands.commands.Info.AboutCommand;
import com.doom.commands.commands.Info.InfoServerCommand;
import com.doom.commands.commands.Info.InfoUserCommand;
import com.doom.commands.commands.Info.ModsCommand;
import com.doom.commands.commands.Math.MathCommand;
import com.doom.commands.commands.Money.*;
import com.doom.commands.commands.Others.*;
import com.doom.commands.commands.Pro.ProCommand;
import com.doom.commands.commands.ReactionRole.ReactionRoleCommand;
import com.doom.commands.commands.ReactionRolePrivate.ReactionRolePrivateCommand;
import com.doom.commands.commands.Shop.InventoryCommand;
import com.doom.commands.commands.Shop.SellCommand;
import com.doom.commands.commands.Shop.ShopCommand;
import com.doom.commands.commands.admin.SetPrefixCommand;
import com.doom.commands.commands.trivia.TriviaCommand;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager(EventWaiter waiter) {
        addCommand(new HelpCommand(this));
        addCommand(new PingCommand());
        addCommand(new InventoryCommand());
        addCommand(new AboutCommand());
        addCommand(new ShopCommand());
        addCommand(new MemeCommand());
        addCommand(new JokeCommand());
        addCommand(new PruneCommand());
        addCommand(new AvatarCommand());
        addCommand(new PollCommand());
        addCommand(new DeathWishCommand());
        addCommand(new SellCommand());
        addCommand(new SpamCommand());
        addCommand(new ReactionRoleCommand());
        addCommand(new ReactionRolePrivateCommand());
        addCommand(new BugCommand());
        addCommand(new Clear());
        addCommand(new Hack());
        addCommand(new EightballCommand());
        addCommand(new BalanceCommand());
        addCommand(new ProCommand());
        addCommand(new StealCommand());
        addCommand(new BalanceBankCommand());
        addCommand(new WithdrawCommand());
        addCommand(new ShareCommand());
        addCommand(new RobCommand());
        addCommand(new AddToServer());
        addCommand(new BankCommand());
        addCommand(new HangManCommand());
        addCommand(new GuessNumberCommand());
        addCommand(new RPSCommand());
        addCommand(new GameCommand());
        addCommand(new AsciiCommand());
        addCommand(new KickCommand());
        addCommand(new BanCommand());
        addCommand(new MuteCommand());
        addCommand(new DeafenCommand());
        addCommand(new SoftBanCommand());
        addCommand(new SetPrefixCommand());
        addCommand(new AddRoleCommand());
        addCommand(new WebhookCommand());
        addCommand(new ServerCommand());
        addCommand(new ServerListCommand());
        addCommand(new PasteCommand());
        addCommand(new TriviaCommand());
        addCommand(new InfoUserCommand());
        addCommand(new InfoServerCommand());
        addCommand(new NumberCommand());
        addCommand(new SayCommand());
        addCommand(new MathCommand());
        addCommand(new EmojiCommand());
        addCommand(new ModsCommand());
        addCommand(new PrivateSpamCommand());
    }

    private void addCommand(ICommand cmd) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present, " + cmd.getName() + " in " + cmd.getClass());
        }

        commands.add(cmd);
    }

    public List<ICommand> getCommands() { return commands; }

    @Nullable
    public ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }


    void handle(GuildMessageReceivedEvent event, String prefix) throws InterruptedException {
        String[] split = event.getMessage().getContentRaw()
                .replaceFirst("(?i)" + Pattern.quote(prefix), "")
                .split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            System.out.println("Processed 1/3");

            CommandContext ctx = new CommandContext(event, args);

            System.out.println("Processed 2/3");

            cmd.handle(ctx);

            System.out.println("Processed 3/3");
        }
    }
}
