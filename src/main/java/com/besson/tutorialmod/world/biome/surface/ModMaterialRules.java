package com.besson.tutorialmod.world.biome.surface;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule ICE_ETHER = makeStateRule(ModBlocks.ICE_ETHER_BLOCK);
    private static final MaterialRules.MaterialRule DIAMOND = makeStateRule(Blocks.DIAMOND_BLOCK);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.DIAMOND_BIOME),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, DIAMOND)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, ICE_ETHER)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
