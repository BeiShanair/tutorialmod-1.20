package com.besson.tutorialmod.item;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.item.custom.FireEther;
import com.besson.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ICE_ETHER = registerItems("ice_ether",new Item(new FabricItemSettings()));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether",new Item(new FabricItemSettings()));
    public static final Item PROSPECTOR = registerItems("prospector",new Prospector(new FabricItemSettings().maxDamage(64)));
    public static final Item FIRE_ETHER = registerItems("fire_ether",new FireEther(new FabricItemSettings().maxDamage(128)));

    private static void addItemsToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(ICE_ETHER);
    }
    private static Item registerItems(String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name),item);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIG);
    }
}
