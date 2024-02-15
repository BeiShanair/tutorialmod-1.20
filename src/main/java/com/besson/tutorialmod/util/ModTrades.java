package com.besson.tutorialmod.util;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModTrades {
    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,2),
                    new ItemStack(ModItems.STRAWBERRY,6),
                    6,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD,6),
                    new ItemStack(ModItems.CORN_SEEDS,3),
                    5,7,0.075f
            ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.ICE_ETHER,16),
                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.SHARPNESS,2)),
                    3,12,0.05f
            ));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ICE_ETHER_MASTER,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.ICE_ETHER,16),
                    new ItemStack(ModBlocks.ICE_ETHER_BLOCK,2),
                    3,12,0.05f
            ));
                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ICE_ETHER_MASTER,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.RAW_ICE_ETHER,32),
                            new ItemStack(ModItems.PROSPECTOR,1),
                            3,24,0.05f
                    ));
                });
    }
}
