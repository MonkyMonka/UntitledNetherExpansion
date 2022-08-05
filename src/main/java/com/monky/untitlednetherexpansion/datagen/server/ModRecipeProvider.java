package com.monky.untitlednetherexpansion.datagen.server;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        // Shaped Recipes
        ShapedRecipeBuilder.shaped(ItemInit.WAYFINDER_ITEM.get())
                .define('c', Items.CRYING_OBSIDIAN.asItem())
                .define('n', Items.NETHERITE_SCRAP.asItem())
                .define('g', Items.GOLD_INGOT.asItem())
                .pattern(" n ").pattern("gcg").pattern(" n ")
                .unlockedBy("has_" + BlockInit.MAGNETITE_BLOCK.get().getRegistryName().getPath(), has(BlockInit.MAGNETITE_BLOCK.get().asItem()))
                .save(consumer, new ResourceLocation(UntitledNetherExpansion.MOD_ID,
                        ItemInit.WAYFINDER_ITEM.get().getRegistryName().getPath()));

        // Shapeless Recipes
        ShapelessRecipeBuilder.shapeless(BlockInit.MAGNETITE_BLOCK.get().asItem(), 4)
                .requires(Items.BASALT)
                .requires(Items.BASALT)
                .requires(Items.BASALT)
                .requires(Items.BASALT)
                .unlockedBy("has_" + ItemInit.WAYFINDER_ITEM.get().getRegistryName().getPath(), has(ItemInit.WAYFINDER_ITEM.get().asItem()))
                .save(consumer, new ResourceLocation(UntitledNetherExpansion.MOD_ID,
                        BlockInit.MAGNETITE_BLOCK.get().getRegistryName().getPath()));

        //Smelting recipe
        /*
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.BLOCK.get().asItem()),
				ItemInit.RESULT.get(), 1f, 200)
		.unlockedBy("has_" + BlockInit.BLOCK.get().getRegistryName().getPath(), has(BlockInit.BLOCK.get().asItem()))
		.save(consumer, new ResourceLocation(TutorialMod.MOD_ID,
						ItemInit.RESULT.get().getRegistryName().getPath() + "_smelting"));
         */


    }

}
