package com.monky.untitlednetherexpansion.datagen.server;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.TagInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(TagInit.Blocks.COOL_BLOCKS).add(Blocks.ACACIA_LEAVES).add(BlockInit.WHISKER_BLOCK.get());
    }
}
