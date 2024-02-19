package com.besson.tutorialmod.entity;

import com.besson.tutorialmod.TutorialMod;
import com.besson.tutorialmod.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TigerEntity> TIGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID,"tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());
}
