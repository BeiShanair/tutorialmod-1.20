package com.besson.tutorialmod.world;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> ICE_ETHER_ORE_KEY = registerKey("ice_ether_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_ICE_ETHER_ORE_KEY = registerKey("nether_ice_ether_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_ICE_ETHER_ORE_KEY = registerKey("end_ice_ether_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stonePlace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatePlace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherPlace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endPlace = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overWorld =
                List.of(OreFeatureConfig.createTarget(stonePlace, ModBlocks.ICE_ETHER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslatePlace,ModBlocks.ICE_ETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> nether =
                List.of(OreFeatureConfig.createTarget(netherPlace, ModBlocks.ICE_ETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> end =
                List.of(OreFeatureConfig.createTarget(endPlace, ModBlocks.ICE_ETHER_ORE.getDefaultState()));

        register(context,ICE_ETHER_ORE_KEY,Feature.ORE,new OreFeatureConfig(overWorld,12));
        register(context,NETHER_ICE_ETHER_ORE_KEY,Feature.ORE,new OreFeatureConfig(nether,12));
        register(context,END_ICE_ETHER_ORE_KEY,Feature.ORE,new OreFeatureConfig(end,12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
