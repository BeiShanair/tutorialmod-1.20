package com.besson.tutorialmod.item.custom;

import com.besson.tutorialmod.sounds.ModSounds;
import com.besson.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Prospector extends Item {
    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for (int i = -64;i <= blockPos.getY() +64; i++){
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if (isRightBlock(state)){
                    outputMessage(blockPos.down(i),player,state.getBlock());
                    foundBlock = true;

                    context.getWorld().playSound(null,blockPos, ModSounds.PROSPECTOR_CALL,
                            SoundCategory.BLOCKS,1f,1f);
                    break;
                }
            }
            if (!foundBlock){
                player.sendMessage(Text.literal("No Ore Found!"));
            }
        }
        context.getStack().damage(1,context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }

    private void outputMessage(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found" + block.asItem().getName().getString() + "at" +
                "(" + down.getX() + "," + down.getY() + "," +down.getZ() + ")!"),false);
    }

    private boolean isRightBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.PROSPECTOR_LIST);
    }
}
