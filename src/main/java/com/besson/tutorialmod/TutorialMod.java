package com.besson.tutorialmod;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItemGroup;
import com.besson.tutorialmod.item.ModItems;
import com.besson.tutorialmod.sounds.ModSounds;
import com.besson.tutorialmod.util.ModLootTableModifiers;
import com.besson.tutorialmod.util.ModTrades;
import com.besson.tutorialmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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

		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE,2000);
	}
}