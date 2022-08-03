package com.monky.untitlednetherexpansion.datagen;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

import static com.monky.untitlednetherexpansion.init.ItemInit.WAYFINDER_ITEM;

@Mod.EventBusSubscriber(modid = UntitledNetherExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Recipes extends RecipeProvider {



    public Recipes(DataGenerator p_125973_) {
        super(p_125973_);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(WAYFINDER_ITEM.get()).save(consumer);
        super.buildCraftingRecipes(consumer);
    }
}
