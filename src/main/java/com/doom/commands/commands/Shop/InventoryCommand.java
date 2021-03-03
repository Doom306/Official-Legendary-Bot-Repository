package com.doom.commands.commands.Shop;

import com.doom.commands.CommandContext;
import com.doom.commands.ICommand;
import com.doom.commands.commands.Money.MoneyData;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class InventoryCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        StringBuilder message = new StringBuilder();
        StringBuilder message1 = new StringBuilder();

        EmbedBuilder embedBuilder = new EmbedBuilder();

         Integer egg = ShopData.goldenEgg.get(ctx.getAuthor());
         Integer soldier = ShopData.soldier.get(ctx.getAuthor());
         Integer sailor = ShopData.sailor.get(ctx.getAuthor());
         Integer pilots = ShopData.pilot.get(ctx.getAuthor());
         Integer nurse = ShopData.nurse.get(ctx.getAuthor());
         Integer captain = ShopData.captain.get(ctx.getAuthor());
         Integer doctor = ShopData.doctor.get(ctx.getAuthor());
         Integer bomberPilots = ShopData.bomberPilots.get(ctx.getAuthor());
         Integer general = ShopData.general.get(ctx.getAuthor());
         Integer suicidePilots = ShopData.suicidePilots.get(ctx.getAuthor());
         Integer darkTrooper = ShopData.drakTrooper.get(ctx.getAuthor());
         Integer nationalGuard = ShopData.nationalGuard.get(ctx.getAuthor());
         Integer darkVader = ShopData.drakVader.get(ctx.getAuthor());
         Integer blackHole = ShopData.blackHole.get(ctx.getAuthor());
         Integer nuclearBomb = ShopData.nuclearBomb.get(ctx.getAuthor());

        if (!ctx.getMessage().getMentionedMembers().isEmpty()) {
            final User member = ctx.getMessage().getMentionedUsers().get(0);
            egg = ShopData.goldenEgg.get(member);
            soldier = ShopData.soldier.get(member);
            sailor = ShopData.sailor.get(member);
            pilots = ShopData.pilot.get(member);
            nurse = ShopData.nurse.get(member);
            captain = ShopData.captain.get(member);
            doctor = ShopData.doctor.get(member);
            bomberPilots = ShopData.bomberPilots.get(member);
            general = ShopData.general.get(member);
            suicidePilots = ShopData.suicidePilots.get(member);
            darkTrooper = ShopData.drakTrooper.get(member);
            nationalGuard = ShopData.nationalGuard.get(member);
            darkVader = ShopData.drakVader.get(member);
            blackHole = ShopData.blackHole.get(member);
            nuclearBomb = ShopData.nuclearBomb.get(member);
            final Double money = MoneyData.money.get(ctx.getAuthor());
            MoneyData.money.put(ctx.getAuthor(), money - 10_000);
            ctx.getChannel().sendMessage("10,000 coins has been deducted for spying the enemies troops").queue();
        }

        embedBuilder.setColor(Color.cyan);

        if (soldier > 0) {
            message.append("Soldiers - ").append(soldier).append("\n");
        } else {
            message.append("Soldiers - 0");
            message.append("\n");
        }

        if (sailor > 0) {
            message.append("Sailor - ").append(sailor).append("\n");
        } else {
            message.append("Sailor - 0");
            message.append("\n");
        }

        if (pilots > 0) {
            message.append("Pilots - ").append(pilots).append("\n");
        } else {
            message.append("Pilots - 0");
            message.append("\n");
        }

        if (nurse > 0) {
            message.append("Nurse - ").append(nurse).append("\n");
        } else {
            message.append("Nurse - 0");
            message.append("\n");
        }

        if (captain > 0) {
            message.append("Captain - ").append(captain).append("\n");
        } else {
            message.append("Captain - 0");
            message.append("\n");
        }

        if (doctor > 0) {
            message.append("Doctor - ").append(doctor).append("\n");
        } else {
            message.append("Doctor - 0");
            message.append("\n");
        }

        if (bomberPilots > 0) {
            message.append("Bomber Pilots - ").append(bomberPilots).append("\n");
        } else {
            message.append("Bomber Pilots - 0");
            message.append("\n");
        }

        if (general > 0) {
            message.append("General - ").append(general).append("\n");
        } else {
            message.append("General - 0");
            message.append("\n");
        }

        if (suicidePilots > 0) {
            message.append("Suicide Pilots - ").append(suicidePilots).append("\n");
        } else {
            message.append("Suicide Pilots - 0");
            message.append("\n");
        }

        if (darkTrooper > 0) {
            message1.append("Dark Trooper - ").append(darkTrooper).append("\n");
        } else {
            message1.append("Dark Trooper - 0");
            message1.append("\n");
        }

        if (nationalGuard > 0) {
            message1.append("National Guard - ").append(nationalGuard).append("\n");
        } else {
            message1.append("National Guard - 0");
            message1.append("\n");
        }

        if (darkVader > 0) {
            message1.append("Dark Vader - ").append(darkVader).append("\n");
        } else {
            message1.append("Dark Vader - 0");
            message1.append("\n");
        }

        if (nuclearBomb > 0) {
            message1.append("Nuclear Bomb - ").append(nuclearBomb).append("\n");
        } else {
            message1.append("Nuclear Bomb - 0");
            message1.append("\n");
        }

        if (blackHole > 0) {
            message1.append("Black Hole - ").append(blackHole).append("\n");
        } else {
            message1.append("Black Hole - 0");
            message1.append("\n");
        }

        if (egg > 0) {
            message1.append("Golden Egg - ").append(egg).append("\n");
        } else {
            message1.append("Golden Egg - 0");
            message1.append("\n");
        }

        embedBuilder.setTitle("Inventory");
        embedBuilder.setAuthor(ctx.getAuthor().getName() + "'s inventory");
        embedBuilder.addField(message.toString(), "", false);
        embedBuilder.addField(message1.toString(), "", false);

        ctx.getChannel().sendMessage("Pssst. Check your DM's").queue();
        ctx.getAuthor().openPrivateChannel().queue(PrivateChannel ->
                PrivateChannel.sendMessage(embedBuilder.build())
                        .queue());
    }

    @Override
    public String getName() {
        return "inv";
    }

    @Override
    public String getHelp() {
        return "Shows your items in your inventory";
    }
}
