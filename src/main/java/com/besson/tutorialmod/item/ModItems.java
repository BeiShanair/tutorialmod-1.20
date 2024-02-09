package com.besson.tutorialmod.item;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.item.custom.FireEther;
import com.besson.tutorialmod.item.custom.ModArmorItem;
import com.besson.tutorialmod.item.custom.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ICE_ETHER = registerItems("ice_ether",new Item(new FabricItemSettings()));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether",new Item(new FabricItemSettings()));
    public static final Item PROSPECTOR = registerItems("prospector",new Prospector(new FabricItemSettings().maxDamage(64)));
    public static final Item FIRE_ETHER = registerItems("fire_ether",new FireEther(new FabricItemSettings().maxDamage(128)));
    public static final Item CORN =registerItems("corn",new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item ANTHRACITE = registerItems("anthracite",new Item(new FabricItemSettings()));
    public static final Item FIRE_ETHER_PICKAXE = registerItems("fire_ether_pickaxe",
            new PickaxeItem(ModToolMaterial.FIRE_ETHER,2,2f,new  FabricItemSettings()));
    public static final Item FIRE_ETHER_AXE = registerItems("fire_ether_axe",
            new AxeItem(ModToolMaterial.FIRE_ETHER,3,1f,new  FabricItemSettings()));
    public static final Item FIRE_ETHER_SHOVEL = registerItems("fire_ether_shovel",
            new ShovelItem(ModToolMaterial.FIRE_ETHER,0,0f,new  FabricItemSettings()));
    public static final Item FIRE_ETHER_SWORD = registerItems("fire_ether_sword",
            new SwordItem(ModToolMaterial.FIRE_ETHER,5,3f,new  FabricItemSettings()));
    public static final Item FIRE_ETHER_HOE = registerItems("fire_ether_hoe",
            new HoeItem(ModToolMaterial.FIRE_ETHER,0,0f,new  FabricItemSettings()));
    public static final Item ICE_ETHER_HELMET = registerItems("ice_ether_helmet",
            new ModArmorItem(ModArmorMaterial.ICE_ETHER, ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item ICE_ETHER_CHESTPLATE = registerItems("ice_ether_chestplate",
            new ArmorItem(ModArmorMaterial.ICE_ETHER, ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item ICE_ETHER_LEGGINGS = registerItems("ice_ether_leggings",
            new ArmorItem(ModArmorMaterial.ICE_ETHER, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item ICE_ETHER_BOOTS = registerItems("ice_ether_boots",
            new ArmorItem(ModArmorMaterial.ICE_ETHER, ArmorItem.Type.BOOTS,new FabricItemSettings()));

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
