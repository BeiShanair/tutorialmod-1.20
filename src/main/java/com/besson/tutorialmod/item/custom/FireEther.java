package com.besson.tutorialmod.item.custom;

import com.besson.tutorialmod.block.ModBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class FireEther extends Item {
    public FireEther(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){
            PlayerEntity player = context.getPlayer();
            ItemStack stack = context.getStack();
            BlockState blockState = world.getBlockState(context.getBlockPos());
            lightFire(blockState,context,player);
            stack.damage(1,player,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }
        return ActionResult.SUCCESS;
    }

    private void lightFire(BlockState blockState, ItemUsageContext context, PlayerEntity player) {
        boolean playerNotOnFire = !player.isOnFire();
        if (context.getWorld().getRandom().nextFloat() > 0.5f){
            lightEntityOnFire(player,200);
        } else if (playerNotOnFire && blockIsRight(blockState)) {
            gainFAandDB(player,context.getWorld(),context.getBlockPos());
        }else {
            lightGround(context);
        }
    }

    private boolean blockIsRight(BlockState blockState) {
        return blockState.isOf(ModBlocks.ICE_ETHER_BLOCK);
    }

    private void lightEntityOnFire(PlayerEntity player, int i) {
        player.setFireTicks(i);
    }

    private void gainFAandDB(PlayerEntity player, World world, BlockPos blockPos) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,200));
        world.breakBlock(blockPos,false);
    }

    private void lightGround(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos blockPos1 = blockPos.offset(context.getSide());
        if (AbstractFireBlock.canPlaceAt(world, blockPos1, context.getHorizontalPlayerFacing())){
            world.playSound(player, blockPos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat() * 0.4f + 0.8f);
            BlockState blockState2 = AbstractFireBlock.getState(world, blockPos1);
            world.setBlockState(blockPos1, blockState2, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            world.emitGameEvent((Entity)player, GameEvent.BLOCK_PLACE, blockPos);
        }
    }
}
