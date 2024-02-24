package com.besson.tutorialmod.world.biome;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi{
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(TutorialMod.MOD_ID,"overworld"),4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,TutorialMod.MOD_ID, ModMaterialRules.makeRules());
    }
}
