package com.besson.tutorialmod.block;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.custom.FireEtherBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ICE_ETHER_BLOCK = registerBlocks("ice_ether_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block RAW_ICE_ETHER_BLOCK =registerBlocks("raw_ice_ether_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_ORE = registerBlocks("ice_ether_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(5f),UniformIntProvider.create(2,5)));
    public static final Block FIRE_ETHER_BLOCK = registerBlocks("fire_ether_block",
            new FireEtherBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_STAIR = registerBlocks("ice_ether_stair",
            new StairsBlock(ModBlocks.ICE_ETHER_BLOCK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_SLAB = registerBlocks("ice_ether_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_BUTTON = registerBlocks("ice_ether_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE),BlockSetType.STONE,20,true));
    public static final Block ICE_ETHER_PRESSURE_PLATE = registerBlocks("ice_ether_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.STONE),BlockSetType.STONE));
    public static final Block ICE_ETHER_FENCE = registerBlocks("ice_ether_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_FENCE_GATE = registerBlocks("ice_ether_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.STONE),WoodType.OAK));
    public static final Block ICE_ETHER_WALL = registerBlocks("ice_ether_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    public static final Block ICE_ETHER_DOOR = registerBlocks("ice_ether_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(),BlockSetType.STONE));
    public static final Block ICE_ETHER_TRAPDOOR = registerBlocks("ice_ether_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(),BlockSetType.STONE));
    private static Block registerBlocks(String name,Block block){
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(TutorialMod.MOD_ID,name),block);
    }
    private static Item registerBlockItems(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }
    public static void registerModBlocks(){

    }
}
