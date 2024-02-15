package com.besson.tutorialmod.villager;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> ICE_ETHER_POI_KEY = point("ice_ether_poi");
    public static final PointOfInterestType ICE_ETHER_POI = registerPointOfInterestType("ice_ether_poi", ModBlocks.ICE_ETHER_BLOCK);
    public static final VillagerProfession ICE_ETHER_MASTER = registerVillagerProfession("ice_ether_master",ICE_ETHER_POI_KEY);
    private static VillagerProfession registerVillagerProfession(String name,RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION,new Identifier(TutorialMod.MOD_ID,name),
                new VillagerProfession(name,entry -> entry.matchesKey(type),entry -> entry.matchesKey(type),
                        ImmutableSet.of(),ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }
    private static PointOfInterestType registerPointOfInterestType(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(TutorialMod.MOD_ID,name),1,1,block);
    }
    private static RegistryKey<PointOfInterestType> point(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE,new Identifier(TutorialMod.MOD_ID,name));
    }
    public static void registerVillagers(){

    }
}
