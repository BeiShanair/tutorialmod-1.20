package com.besson.tutorialmod.entity.client;

import com.besson.tutorialmod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer TIGER =
            new EntityModelLayer(new Identifier(TutorialMod.MOD_ID,"tiger"),"main");
}
