package com.besson.tutorialmod.sounds;

import com.besson.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent PROSPECTOR_CALL = registerSoundEvents("prospector_call");
    public static final SoundEvent BLOCK_BREAK = registerSoundEvents("block_break");
    public static final SoundEvent BLOCK_STEP = registerSoundEvents("block_step");
    public static final SoundEvent BLOCK_PLACE = registerSoundEvents("block_place");
    public static final SoundEvent BLOCK_HIT = registerSoundEvents("block_hit");
    public static final SoundEvent BLOCK_FALL = registerSoundEvents("block_fall");
    public static final SoundEvent HAPPY_NEW_YEAR = registerSoundEvents("happy_new_year");
    public static final BlockSoundGroup BLOCK_SOUND_GROUP = new BlockSoundGroup(1f,1f,
            ModSounds.BLOCK_BREAK,ModSounds.BLOCK_STEP,ModSounds.BLOCK_PLACE,ModSounds.BLOCK_HIT,ModSounds.BLOCK_FALL);
    public static SoundEvent registerSoundEvents(String name){
        Identifier identifier = new Identifier(TutorialMod.MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,identifier,SoundEvent.of(identifier));
    }
    public static void registerSounds(){

    }
}
