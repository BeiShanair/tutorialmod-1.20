package com.besson.tutorialmod.util;

import com.besson.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK,new Identifier(TutorialMod.MOD_ID,name));
        }
    }
    public static class Items{

    }
}
