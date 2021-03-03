package com.doom.commands.commands.Shop;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Money.MoneyData;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class SellCommand implements ICommand {
    EmbedBuilder embedBuilder = new EmbedBuilder();

    @Override
    public void handle(CommandContext ctx) {
        if (ctx.getArgs().isEmpty()) {
            String message =
                    "1.) Soldier [Ground]\n" +
                            "- `/sell soldier`\n" +
                            "2.) Sailor [Navy]\n" +
                            "- `/sell sailor`\n" +
                            "3.) Pilots [Air]\n" +
                            "- `/sell pilot`\n" +
                            "4.) Nurse\n" +
                            "- `/sell nurse`\n\n";
            embedBuilder.setTitle("Sell");
            embedBuilder.setColor(Color.RED);
            embedBuilder.setFooter("Sell some troops that are crappy!!!");
            embedBuilder.addField("Common", message, false);
            message = "1.) General [Ground]\n" +
                    "- `/sell general`\n" +
                    "2.) Captain [Navy]\n" +
                    "- `/sell captain`\n" +
                    "3.) Bomber Pilots [Air]\n" +
                    "- `/sell bpilot`\n" +
                    "4.) Doctors\n" +
                    "- `/sell doctor\n\n" +
                    "5.) Suicide Pilots [Air]\n" +
                    "- `/sell spilot`\n";
            embedBuilder.addField("Uncommon", message, false);
            message = "1.) Dark Troopers [All]\n" +
                    "- `/sell dtrooper`\n" +
                    "2.) National Guard [Ground]\n" +
                    "- `/sell nguard";
            embedBuilder.addField("Rare", message, false);
            message = "1.) Dark Vader\n" +
                    "- `/sell vader";
            embedBuilder.addField("Legendary", message, false);
            message = "1.) Nuclear Bomb\n" +
                    "- `/sell nuclear`\n" +
                    "2.) Black hole\n" +
                    "- `/sell blackhole";
            embedBuilder.addField("Mystic", message, false);
            ctx.getChannel().sendMessage(embedBuilder.build()).queue();
            return;
        }

        int howManyCount = 1;

        try {
            if (!ctx.getArgs().get(1).isEmpty()) {
                howManyCount = Integer.parseInt(ctx.getArgs().get(1));
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        final Integer soldier = ShopData.soldier.get(ctx.getAuthor());
        final Integer sailor = ShopData.sailor.get(ctx.getAuthor());
        final Integer pilots = ShopData.pilot.get(ctx.getAuthor());
        final Integer nurse = ShopData.nurse.get(ctx.getAuthor());
        final Integer captain = ShopData.captain.get(ctx.getAuthor());
        final Integer doctor = ShopData.doctor.get(ctx.getAuthor());
        final Integer bomberPilots = ShopData.bomberPilots.get(ctx.getAuthor());
        final Integer general = ShopData.general.get(ctx.getAuthor());
        final Integer suicidePilots = ShopData.suicidePilots.get(ctx.getAuthor());
        final Integer darkTrooper = ShopData.drakTrooper.get(ctx.getAuthor());
        final Integer nationalGuard = ShopData.nationalGuard.get(ctx.getAuthor());
        final Integer darkVader = ShopData.drakVader.get(ctx.getAuthor());
        final Integer blackHole = ShopData.blackHole.get(ctx.getAuthor());
        final Integer nuclearBomb = ShopData.nuclearBomb.get(ctx.getAuthor());
        final Double money = MoneyData.money.get(ctx.getAuthor());
        final String item = ctx.getArgs().get(0);
        int cost = 1500;

        if (item.equals("soldier")) {
                ctx.getChannel().sendMessage("Sir, soldier(s) from the military has been successfully sold for \uD83E\uDE99 " + (howManyCount/2) + ".").queue();
                ShopData.soldier.put(ctx.getAuthor(), soldier - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (howManyCount/2));
                return;
        }

        if (item.equals("sailor")) {
                ctx.getChannel().sendMessage("Sir, sailor(s) from the Navy has been successfully sold for \uD83E\uDE99 " + howManyCount/2 + ".").queue();
                ShopData.sailor.put(ctx.getAuthor(), sailor - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (howManyCount/2));
                return;

        }

        if (item.equals("pilot")) {
                ctx.getChannel().sendMessage("Pilot(s) from the Air Force has been successfully sold for \uD83E\uDE99 " + howManyCount/2 + ".").queue();
                ShopData.pilot.put(ctx.getAuthor(), pilots - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (howManyCount/2));
                return;
        }

        if (item.equals("nurse")) {
                ctx.getChannel().sendMessage("Nurse(s) has been successfully sold for \uD83E\uDE99 " + howManyCount/2 + ".").queue();
                ShopData.nurse.put(ctx.getAuthor(), nurse - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (howManyCount/2));
                return;
        }

        if (item.equals("captain")) {
                ctx.getChannel().sendMessage("Captain(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.captain.put(ctx.getAuthor(), captain - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;

        }

        if (item.equals("doctor")) {
                ctx.getChannel().sendMessage("Doctor(s) has left the medical field for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.doctor.put(ctx.getAuthor(), doctor - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;

        }

        if (item.equals("bpilot")) {
                ctx.getChannel().sendMessage("Captain(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.bomberPilots.put(ctx.getAuthor(), bomberPilots - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;

        }

        if (item.equals("spilot")) {
                ctx.getChannel().sendMessage("Captain(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.suicidePilots.put(ctx.getAuthor(), suicidePilots - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;

        }

        if (item.equals("general")) {
                ctx.getChannel().sendMessage("General(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.general.put(ctx.getAuthor(), general - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;
        }

        cost = 70_000;

        if (item.equals("dtrooper")) {
                ctx.getChannel().sendMessage("The Dark Trooper(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.drakTrooper.put(ctx.getAuthor(), darkTrooper - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;
        }

        if (item.equals("nguard")) {
                ctx.getChannel().sendMessage("The National Guard(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.nationalGuard.put(ctx.getAuthor(), nationalGuard - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;
        }

        cost = 700_000;

        if (item.equals("vader")) {
                ctx.getChannel().sendMessage("The Legendary Dark Vader(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.drakVader.put(ctx.getAuthor(), darkVader - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;
        }

        cost = 2_000_000;

        if (item.equals("nuclear")) {
                ctx.getChannel().sendMessage("The Mystic Nuclear bomb(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.nuclearBomb.put(ctx.getAuthor(), nuclearBomb - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;

        }

        if (item.equals("blackhole")) {
                ctx.getChannel().sendMessage("The Mystic Black Hole(s) has left our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.blackHole.put(ctx.getAuthor(), blackHole - howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money + (cost * howManyCount));
                return;
        }


        String message =
                "1.) Soldier [Ground]\n" +
                        "- `/sell soldier`\n" +
                        "2.) Sailor [Navy]\n" +
                        "- `/sell sailor`\n" +
                        "3.) Pilots [Air]\n" +
                        "- `/sell pilot`\n" +
                        "4.) Nurse\n" +
                        "- `/sell nurse`\n\n";
        embedBuilder.setTitle("Sell");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setFooter("Sell some troops that are crappy!!!");
        embedBuilder.addField("Common", message, false);
        message = "1.) General [Ground]\n" +
                "- `/sell general`\n" +
                "2.) Captain [Navy]\n" +
                "- `/sell captain`\n" +
                "3.) Bomber Pilots [Air]\n" +
                "- `/sell bpilot`\n" +
                "4.) Doctors\n" +
                "- `/sell doctor\n\n" +
                "5.) Suicide Pilots [Air]\n" +
                "- `/sell spilot`\n";
        embedBuilder.addField("Uncommon", message, false);
        message = "1.) Dark Troopers [All]\n" +
                "- `/sell dtrooper`\n" +
                "2.) National Guard [Ground]\n" +
                "- `/sell nguard";
        embedBuilder.addField("Rare", message, false);
        message = "1.) Dark Vader\n" +
                "- `/sell vader";
        embedBuilder.addField("Legendary", message, false);
        message = "1.) Nuclear Bomb\n" +
                "- `/sell nuclear`\n" +
                "2.) Black hole\n" +
                "- `/sell blackhole";
        embedBuilder.addField("Mystic", message, false);
        ctx.getChannel().sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "sell";
    }

    @Override
    public String getHelp() {
        return "Sell items";
    }
}
