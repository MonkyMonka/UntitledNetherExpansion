package com.monky.untitlednetherexpansion.datagen;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.datagen.client.ModBlockStateProvider;
import com.monky.untitlednetherexpansion.datagen.client.ModItemModelProvider;
import com.monky.untitlednetherexpansion.datagen.client.ModSoundDefinitionsProvider;
import com.monky.untitlednetherexpansion.datagen.client.lang.ModEnUsProvider;
import com.monky.untitlednetherexpansion.datagen.server.ModBlockTagsProvider;
import com.monky.untitlednetherexpansion.datagen.server.ModItemTagsProvider;
import com.monky.untitlednetherexpansion.datagen.server.ModLootTableProvider;
import com.monky.untitlednetherexpansion.datagen.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(modid = UntitledNetherExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            // Client Data Generation (Resourcepack gen)
            generator.addProvider(new ModBlockStateProvider(generator, helper));
            generator.addProvider(new ModItemModelProvider(generator, helper));
            generator.addProvider(new ModEnUsProvider(generator));
            generator.addProvider(new ModSoundDefinitionsProvider(generator, helper));
        }

        if (event.includeServer()) {

            ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator,helper);

            // Server Data Generation (Datapack gen)
            generator.addProvider(new ModRecipeProvider(generator));
            generator.addProvider(blockTags);
            generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
            generator.addProvider(new ModLootTableProvider(generator));

        }

    }
}
