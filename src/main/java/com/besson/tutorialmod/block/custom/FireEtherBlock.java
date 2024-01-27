package com.besson.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

public class FireEtherBlock extends Block {
    public FireEtherBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(200);
        super.onEntityLand(world, entity);
    }
}
