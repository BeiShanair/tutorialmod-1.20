package com.besson.tutorialmod.util;

import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft","chests/jungle_temple");
    private static final Identifier SUS_SAND_ID =
            new Identifier("minecraft","archaeology/desert_pyramid");
    public static void modifierLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.PROSPECTOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
            if (JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.CORN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
            if (JUNGLE_TEMPLE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.RAW_ICE_ETHER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,5.0f)));

                tableBuilder.pool(poolBuilder.build());
            }
        });
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (SUS_SAND_ID.equals(id)){
                LootPool.Builder pool = LootPool.builder().with(ItemEntry.builder(ModItems.PROSPECTOR)).with(ItemEntry.builder(ModItems.RAW_ICE_ETHER));
                return LootTable.builder().pool(pool).build();
            }
            return null;
        });
    }
}
