package com.monky.untitlednetherexpansion.datagen.client;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public  ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);

    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.MAGNETITE_BLOCK.get());
    }
}
