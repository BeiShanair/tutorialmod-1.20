package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ANTHRACITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ICE_ETHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_ETHER,Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN,Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR,Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ETHER,Models.GENERATED);
    }
}
