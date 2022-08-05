package com.monky.untitlednetherexpansion.datagen.server;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
        super(generator, blocks, UntitledNetherExpansion.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
       //works the same way as the other Tags provider, just needs to get blocks as items and etc
    }
}
