package com.besson.tutorialmod;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.block.entity.ModBlockEntities;
import com.besson.tutorialmod.entity.ModEntities;
import com.besson.tutorialmod.entity.custom.TigerEntity;
import com.besson.tutorialmod.item.ModItemGroup;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.recipe.ModRecipes;
import com.besson.tutorialmod.screen.ModScreenHandlers;
import com.besson.tutorialmod.sounds.ModSounds;
import com.besson.tutorialmod.util.ModLootTableModifiers;
import com.besson.tutorialmod.util.ModTrades;
import com.besson.tutorialmod.villager.ModVillagers;
import com.besson.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifierLootTables();
		ModTrades.registerTrades();

		ModVillagers.registerVillagers();
		ModSounds.registerSounds();

		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();

		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE,2000);

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.createTigerAttributes());

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ICE_ETHER_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ICE_ETHER_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ICE_ETHER_LOG,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ICE_ETHER_WOOD,5,5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ICE_ETHER_PLANKS,5,20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ICE_ETHER_LEAVES,30,60);

		StrippableBlockRegistry.register(ModBlocks.ICE_ETHER_LOG,ModBlocks.STRIPPED_ICE_ETHER_LOG);
		StrippableBlockRegistry.register(ModBlocks.ICE_ETHER_WOOD,ModBlocks.STRIPPED_ICE_ETHER_WOOD);
	}
}