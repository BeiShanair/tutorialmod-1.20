package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.block.custom.CornCropBlock;
import com.besson.tutorialmod.block.custom.StrawberryCropBlock;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ICE_ETHER_BLOCK);
        addDrop(ModBlocks.RAW_ICE_ETHER_BLOCK);
        addDrop(ModBlocks.FIRE_ETHER_BLOCK);

        addDrop(ModBlocks.ICE_ETHER_STAIR);
        addDrop(ModBlocks.ICE_ETHER_FENCE);
        addDrop(ModBlocks.ICE_ETHER_FENCE_GATE);
        addDrop(ModBlocks.ICE_ETHER_BUTTON);
        addDrop(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
        addDrop(ModBlocks.ICE_ETHER_WALL);
        addDrop(ModBlocks.ICE_ETHER_TRAPDOOR);

        addDrop(ModBlocks.ICE_ETHER_LOG);
        addDrop(ModBlocks.ICE_ETHER_WOOD);
        addDrop(ModBlocks.STRIPPED_ICE_ETHER_LOG);
        addDrop(ModBlocks.STRIPPED_ICE_ETHER_WOOD);
        addDrop(ModBlocks.ICE_ETHER_PLANKS);

        addDrop(ModBlocks.ICE_ETHER_LEAVES,leavesDrops(ModBlocks.ICE_ETHER_LEAVES,ModBlocks.ICE_ETHER_SLAB,0.0025f));

        addDrop(ModBlocks.ICE_ETHER_DOOR,doorDrops(ModBlocks.ICE_ETHER_DOOR));
        addDrop(ModBlocks.ICE_ETHER_SLAB,slabDrops(ModBlocks.ICE_ETHER_SLAB));

        addDrop(ModBlocks.ICE_ETHER_ORE,copperOreLikeDrops(ModBlocks.ICE_ETHER_ORE,ModItems.RAW_ICE_ETHER));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(StrawberryCropBlock.AGE,5));
        addDrop(ModBlocks.STRAWBERRY_CROP,cropDrops(ModBlocks.STRAWBERRY_CROP,ModItems.STRAWBERRY,ModItems.STRAWBERRY_SEEDS,builder));

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE,8));
        addDrop(ModBlocks.CORN_CROP,cropDrops(ModBlocks.CORN_CROP,ModItems.CORN,ModItems.CORN_SEEDS,builder1));

        /*
        AnyOfLootCondition.Builder builder2 =
                BlockStatePropertyLootCondition.builder(ModBlocks.CRON_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 7))
                        .or(BlockStatePropertyLootCondition.builder(ModBlocks.CRON_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 8)));
        */
    }
    public LootTable.Builder copperOreLikeDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
