package com.besson.tutorialmod.item;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TUTORIAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"tutorial_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.tutorial_group"))
                    .icon(()-> new ItemStack(ModItems.ICE_ETHER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ICE_ETHER);
                        entries.add(ModBlocks.ICE_ETHER_BLOCK);
                        entries.add(ModBlocks.RAW_ICE_ETHER_BLOCK);
                        entries.add(ModItems.RAW_ICE_ETHER);
                        entries.add(ModBlocks.ICE_ETHER_ORE);
                        entries.add(ModItems.PROSPECTOR);
                        entries.add(ModItems.FIRE_ETHER);
                        entries.add(ModBlocks.FIRE_ETHER_BLOCK);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.ANTHRACITE);

                        entries.add(ModBlocks.ICE_ETHER_BUTTON);
                        entries.add(ModBlocks.ICE_ETHER_DOOR);
                        entries.add(ModBlocks.ICE_ETHER_FENCE);
                        entries.add(ModBlocks.ICE_ETHER_FENCE_GATE);
                        entries.add(ModBlocks.ICE_ETHER_STAIR);
                        entries.add(ModBlocks.ICE_ETHER_SLAB);
                        entries.add(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
                        entries.add(ModBlocks.ICE_ETHER_WALL);
                        entries.add(ModBlocks.ICE_ETHER_TRAPDOOR);

                        entries.add(ModItems.FIRE_ETHER_PICKAXE);
                        entries.add(ModItems.FIRE_ETHER_AXE);
                        entries.add(ModItems.FIRE_ETHER_SHOVEL);
                        entries.add(ModItems.FIRE_ETHER_SWORD);
                        entries.add(ModItems.FIRE_ETHER_HOE);

                    }).build());
    public static void registerModItemGroup(){

    }
}
