package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.block.custom.CornCropBlock;
import com.besson.tutorialmod.block.custom.StrawberryCropBlock;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool iceEtherPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ICE_ETHER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_ETHER_BLOCK);

        iceEtherPool.stairs(ModBlocks.ICE_ETHER_STAIR);
        iceEtherPool.slab(ModBlocks.ICE_ETHER_SLAB);
        iceEtherPool.button(ModBlocks.ICE_ETHER_BUTTON);
        iceEtherPool.pressurePlate(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
        iceEtherPool.fence(ModBlocks.ICE_ETHER_FENCE);
        iceEtherPool.fenceGate(ModBlocks.ICE_ETHER_FENCE_GATE);
        iceEtherPool.wall(ModBlocks.ICE_ETHER_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.ICE_ETHER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ICE_ETHER_TRAPDOOR);

        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE,0,1,2,3,4,5);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE,0,1,2,3,4,5,6,7,8);

        blockStateModelGenerator.registerSimpleState(ModBlocks.POLISHING_MACHINE);

        blockStateModelGenerator.registerLog(ModBlocks.ICE_ETHER_LOG).log(ModBlocks.ICE_ETHER_LOG).wood(ModBlocks.ICE_ETHER_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ICE_ETHER_LOG).log(ModBlocks.STRIPPED_ICE_ETHER_LOG).wood(ModBlocks.STRIPPED_ICE_ETHER_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_LEAVES);

        blockStateModelGenerator.registerTintableCross(ModBlocks.ICE_ETHER_TREE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ANTHRACITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ICE_ETHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_ETHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN,Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR,Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ETHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY,Models.GENERATED);
        itemModelGenerator.register(ModItems.HAPPY_NEW_YEAR_MUSIC_DISC,Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_ETHER_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_AXE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_SHOVEL,Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_HOE,Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_SWORD,Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_BOOTS);

        itemModelGenerator.register(ModItems.TIGER_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
