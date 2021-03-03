package com.doom.commands.commands.Shop;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Money.MoneyData;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ShopCommand implements ICommand {
    EmbedBuilder embedBuilder = new EmbedBuilder();

    @Override
    public void handle(CommandContext ctx) {
        if (!MoneyData.money.containsKey(ctx.getAuthor())) {
            ctx.getChannel().sendMessage("You have no money at all!!!\n" +
                    "You also think that you could buy something").queue();
            return;
        }

        if (MoneyData.money.get(ctx.getAuthor()).intValue() == 0) {
            ctx.getChannel().sendMessage("You have no money at all!!!\n" +
                    "You also think that you could buy something").queue();
            return;
        }

        if (ctx.getArgs().isEmpty()) {
            String message =
                    "1.) Soldier [Ground]\n" +
                            "- `/shop soldier`\n" +
                            "2.) Sailor [Navy]\n" +
                            "- `/shop sailor`\n" +
                            "3.) Pilots [Air]\n" +
                            "- `/shop pilot`\n" +
                            "4.) Nurse\n" +
                            "- `/shop nurse`\n\n";
            embedBuilder.setTitle("Invalid Input");
            embedBuilder.setColor(Color.RED);
            embedBuilder.setFooter("Check your spelling!!!");
            embedBuilder.addField("Common", message, false);
            message = "1.) General [Ground]\n" +
                    "- `/shop general`\n" +
                    "2.) Captain [Navy]\n" +
                    "- `/shop captain`\n" +
                    "3.) Bomber Pilots [Air]\n" +
                    "- `/shop bpilot`\n" +
                    "4.) Doctors\n" +
                    "- `/shop doctor\n\n" +
                    "5.) Suicide Pilots [Air]\n" +
                    "- `/shop spilot`\n";
            embedBuilder.addField("Uncommon", message, false);
            message = "1.) Dark Troopers [All]\n" +
                    "- `/shop dtrooper`\n" +
                    "2.) National Guard [Ground]\n" +
                    "- `/shop nguard";
            embedBuilder.addField("Rare", message, false);
            message = "1.) Dark Vader\n" +
                    "- `/shop vader";
            embedBuilder.addField("Legendary", message, false);
            message = "1.) Nuclear Bomb\n" +
                    "- `/shop nuclear`\n" +
                    "2.) Black hole\n" +
                    "- `/shop blackhole";
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
        final String item  = ctx.getArgs().get(0);
        int cost = 3000;

        if (item.equals("soldier")) {
            if (money >= howManyCount) {
                ctx.getChannel().sendMessage("Sir, soldier(s) from the military has been successfully bought for \uD83E\uDE99 " + howManyCount + ".").queue();
                ShopData.soldier.put(ctx.getAuthor(), soldier + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("sailor")) {
            if (money >= howManyCount) {
                ctx.getChannel().sendMessage("Sir, sailor(s) from the Navy has been successfully bought for \uD83E\uDE99 " + howManyCount + ".").queue();
                ShopData.sailor.put(ctx.getAuthor(), sailor + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("pilot")) {
            if (money >= howManyCount) {
                ctx.getChannel().sendMessage("Pilot(s) from the Air Force has been successfully bought for \uD83E\uDE99 " + howManyCount + ".").queue();
                ShopData.pilot.put(ctx.getAuthor(), pilots + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("nurse")) {
            if (money >= howManyCount) {
                ctx.getChannel().sendMessage("Nurse(s) has been successfully bought for \uD83E\uDE99 " + howManyCount + ".").queue();
                ShopData.nurse.put(ctx.getAuthor(), nurse + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("captain")) {
            if (money >= (cost * howManyCount)) {
                    ctx.getChannel().sendMessage("Captain(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                    ShopData.captain.put(ctx.getAuthor(), captain + howManyCount);
                    MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                    return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("doctor")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("Doctor(s) has joined the medical field for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.doctor.put(ctx.getAuthor(), doctor + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("bpilot")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("Captain(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.bomberPilots.put(ctx.getAuthor(), bomberPilots + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("spilot")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("Captain(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.suicidePilots.put(ctx.getAuthor(), suicidePilots + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("general")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("General(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.general.put(ctx.getAuthor(), general + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        cost = 100_000;

        if (item.equals("dtrooper")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("The Dark Trooper(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.drakTrooper.put(ctx.getAuthor(), darkTrooper + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("nguard")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("The National Guard(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.nationalGuard.put(ctx.getAuthor(), nationalGuard + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        cost = 1_000_000;

        if (item.equals("vader")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("The Legendary Dark Vader(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.drakVader.put(ctx.getAuthor(), darkVader + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        cost = 2_000_000;

        if (item.equals("nuclear")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("The Mystic Nuclear bomb(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.nuclearBomb.put(ctx.getAuthor(), nuclearBomb + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }

        if (item.equals("blackhole")) {
            if (money >= (cost * howManyCount)) {
                ctx.getChannel().sendMessage("The Mystic Black Hole(s) has joined our ranks for the reward of \uD83E\uDE99 " + (cost * howManyCount) + ".").queue();
                ShopData.blackHole.put(ctx.getAuthor(), blackHole + howManyCount);
                MoneyData.money.put(ctx.getAuthor(), money - (cost * howManyCount));
                return;
            }

            ctx.getChannel().sendMessage("You don't have \uD83E\uDE99 " + cost * howManyCount + ".\n" +
                    "Unable to purchase!!!").queue();
            return;
        }


        String message =
                "1.) Soldier [Ground]\n" +
                        "- `/shop soldier`\n" +
                        "2.) Sailor [Navy]\n" +
                        "- `/shop sailor`\n" +
                        "3.) Pilots [Air]\n" +
                        "- `/shop pilot`\n" +
                        "4.) Nurse\n" +
                        "- `/shop nurse`\n\n";
        embedBuilder.setTitle("Invalid Input");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setFooter("Check your spelling!!!");
        embedBuilder.addField("Common", message, false);
        message = "1.) General [Ground]\n" +
                "- `/shop general`\n" +
                "2.) Captain [Navy]\n" +
                "- `/shop captain`\n" +
                "3.) Bomber Pilots [Air]\n" +
                "- `/shop bpilot`\n" +
                "4.) Doctors\n" +
                "- `/shop doctor\n\n" +
                "5.) Suicide Pilots [Air]\n" +
                "- `/shop spilot`\n";
        embedBuilder.addField("Uncommon", message, false);
        message = "1.) Dark Troopers [All]\n" +
                "- `/shop dtrooper`\n" +
                "2.) National Guard [Ground]\n" +
                "- `/shop nguard";
        embedBuilder.addField("Rare", message, false);
        message = "1.) Dark Vader\n" +
                "- `/shop vader";
        embedBuilder.addField("Legendary", message, false);
        message = "1.) Nuclear Bomb\n" +
                "- `/shop nuclear`\n" +
                "2.) Black hole\n" +
                "- `/shop blackhole";
        embedBuilder.addField("Mystic", message, false);
        ctx.getChannel().sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public String getName() {
        return "shop";
    }

    @Override
    public String getHelp() {
        return "Shop for items";
    }
}
