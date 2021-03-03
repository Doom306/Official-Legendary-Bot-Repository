package com.doom.commands.commands.Others;

import com.doom.CommandManager;
import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.List;

public class HelpCommand implements ICommand {

    private final CommandManager manager;

    public HelpCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();

        String group = "Games\n" +
                "type `/help games` to find out what are the commands\n" +
                "\n" +
                "Fun\n" +
                "type `/help fun` to find out what are the commands\n" +
                "\n" +
                "Moderation\n" +
                "type `/help mod` to find out what are the commands";
        String group1 = "Information\n" +
                "type `/help info` to find out what are the commands\n" +
                "\n" +
                "Bot\n" +
                "type `/help bot` to find out what are the commands\n" +
                "\n";

        String group2 = "Currency\n" +
                "type `/help currency` to find out what are the currency commands\n\n" +
                "Future\n" +
                "type `/help future` to find out what are the future commands";

        if (args.isEmpty()) {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Help!!!");
            embedBuilder.setColor(Color.cyan);
            embedBuilder.addField(group,"", false);
            embedBuilder.addField(group1,"", false);
            embedBuilder.addField(group2,"", false);
            embedBuilder.setFooter("\nType `/help [group name]` to see their commands");


            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }

        if (args.get(0).equals("fun")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            EmbedBuilder embedBuilder1 = new EmbedBuilder();
            embedBuilder.setTitle("Fun Commands");
            embedBuilder.setColor(Color.green);
            embedBuilder1.setColor(Color.green);
            embedBuilder.addField("1.) Spam Command","`/spam`", false);
            embedBuilder.addField("2.) Meme Command","`/meme`", false);
            embedBuilder.addField("3.) Joke Command","`/joke`", false);
            embedBuilder.addField("4.) Font Command","`/font`", false);
            embedBuilder.addField("5.) Code Command","`/code`", false);
            embedBuilder.addField("6.) Avatar Command","`/avatar`", false);
            embedBuilder1.addField("7.) Hack Command","`/hack`", false);
            embedBuilder1.addField("8.) Say Command", "`/say`", false);
            embedBuilder1.addField("9.) Math Command", "`/math`", false);
            embedBuilder1.addField("10.) Emoji Command","`/emoji`", false);
            embedBuilder1.addField("11.) Private Spam Command","`/pspam`", false);

            embedBuilder1.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            channel.sendMessage(embedBuilder1.build()).queue();
            return;
        }
        if (args.get(0).equals("games")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Games Commands");
            embedBuilder.setColor(Color.ORANGE);
            embedBuilder.addField("1.) Game info Command*","`/game`", false);
            embedBuilder.addField("2.) Hang man Command*\n","`/hm`", false);
            embedBuilder.addField("3.) Guess the number Command*","`/gn`", false);
            embedBuilder.addField("4.) Rock Paper Scissors Command*","`/rps`", false);
            embedBuilder.addField("5.) Number Command", "`/number`", false);
            embedBuilder.addField("5.) Trivia Command", "`/trivia`", false);
            embedBuilder.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }
        if (args.get(0).equals("info")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Information Commands");
            embedBuilder.setColor(Color.red);
            embedBuilder.addField("1.) User Information Command","`/user`", false);
            embedBuilder.addField("2.) Server Information Command","`/serverinfo`", false);
            embedBuilder.addField("3.) Mod Information Command ","`/mods`", false);
            embedBuilder.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }
        if (args.get(0).equals("bot")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("About the Bot Commands");
            embedBuilder.setColor(Color.blue);
            embedBuilder.addField("1.) Server List Command","`/serverlist`", false);
            embedBuilder.addField("2.) Server Count Command","`/server`", false);
            embedBuilder.addField("3.) Bug Command","`/bug`", false);

            embedBuilder.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }

        if (args.get(0).equals("mod")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            EmbedBuilder embedBuilder1 = new EmbedBuilder();
            embedBuilder.setTitle("Moderation Commands");
            embedBuilder.setColor(Color.red);
            embedBuilder1.setColor(Color.red);
            embedBuilder.addField("1.) Kick Command", "`/kick`", false);
            embedBuilder.addField("2.) Ban Command", "`/ban`", false);
            embedBuilder.addField("3.) Mute Command", "`/mute`", false);
            embedBuilder.addField("4.) Deafen Command", "`/deafen`", false);
            embedBuilder.addField("5.) Clear Command", "`/clear`", false);
            embedBuilder.addField("6.) Delete Command", "`/delete`", false);
            embedBuilder.addField("7.) Death wish Command`BETA`", "`/death`", false);
            embedBuilder1.addField("8.) Set Prefix Command", "`/setprefix`", false);
            embedBuilder1.addField("9.) Add Role Command", "`/role`", false);
            embedBuilder1.addField("10.) Enable Giveaway Win Message", "`/enable`", false);
            embedBuilder1.addField("11.) Disable Giveaway Win Message", "`/disable`", false);
            embedBuilder1.addField("12.) Set Giveaway Win Message", "`/setmessage`", false);
            embedBuilder1.addField("13.) Reaction Role Command", "`/reactrole`", false);
            embedBuilder1.addField("14.) Add Poll Command", "`/setprefix`", false);
            embedBuilder1.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            channel.sendMessage(embedBuilder1.build()).queue();
            return;
        }

        if (args.get(0).equals("currency")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Currency Commands");
            embedBuilder.setColor(Color.red);
            embedBuilder.addField("1.) Deposit Command", "`/dep`", false);
            embedBuilder.addField("2.) Balance Command", "`/bal`", false);
            embedBuilder.addField("3.) Bank Balance Command", "`/bank`", false);
            embedBuilder.addField("4.) Steal Command", "`/steal`", false);
            embedBuilder.addField("5.) Rob Command", "`/rob`", false);
            embedBuilder.addField("5.) Withdraw Command", "`/with`", false);
            embedBuilder.addField("6.) Shop Command", "`/shop`", false);
            embedBuilder.addField("5.) Inventory Command", "`/inv`", false);
            embedBuilder.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }

        if (args.get(0).equals("future")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Future Commands");
            embedBuilder.setColor(Color.red);
            embedBuilder.addField("1.) Fight Command", "`/fight`", false);
            embedBuilder.setFooter("\nType `/help [command name]` to see what they do");

            channel.sendMessage(embedBuilder.build()).queue();
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder();

        String search = args.get(0);
        ICommand command = manager.getCommand(search);

        if (command == null) {
            channel.sendMessage("Nothing found for " + search).queue();
            return;
        }

        embedBuilder.setTitle("Help!!!");
        embedBuilder.setColor(Color.cyan);
        embedBuilder.addField(command.getHelp(), "", false);

        channel.sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Shows the list with commands in the bot\n" +
                "Usage: `/help [command]`";
    }

    @Override
    public List<String> getAliases() {
        List<String> strings = new java.util.ArrayList<>();
        strings.add("commands");
        strings.add("cmds");
        strings.add("commandlist");
        return strings;
    }
}
