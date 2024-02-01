package com.besson.tutorialmod.datagen;

import com.besson.tutorialmod.block.ModBlocks;
import com.besson.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ICE_ETHER_LIST = List.of(ModItems.RAW_ICE_ETHER);
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,ModItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);

        offerSmelting(exporter,ICE_ETHER_LIST,RecipeCategory.MISC,ModItems.ICE_ETHER,
                0.7f,200,"ice_ether");
        offerBlasting(exporter,ICE_ETHER_LIST,RecipeCategory.MISC,ModItems.ICE_ETHER,
                0.7f,100,"ice_ether");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR,3)
                .pattern("###")
                .input('#',Items.BEETROOT)
                .criterion(hasItem(Items.BEETROOT),conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter,new Identifier("sugar_from_beetroot"));
    }
}
