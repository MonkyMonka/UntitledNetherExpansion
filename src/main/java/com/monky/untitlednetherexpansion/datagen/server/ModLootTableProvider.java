package com.monky.untitlednetherexpansion.datagen.server;

import com.monky.untitlednetherexpansion.datagen.BaseLootTableProvider;
import com.monky.untitlednetherexpansion.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModLootTableProvider extends BaseLootTableProvider {

    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTables() {
        dropSelf(BlockInit.WHISKER_BLOCK.get());
        dropSelf(BlockInit.MAGNETITE_BLOCK.get());
        //For silktouch: silkTouch(BlockInit.ROTATABLE_BLOCK.get(), ItemInit.EXAMPLE_ITEM.get(), 1, 4);
    }

    protected void silkTouch(Block block, Item silk, int min, int max) {
        add(block, createSilkTouchTable(block.getRegistryName().getPath(), block, silk, min, max));
    }

    protected void dropSelf(Block block) {
        add(block, createSimpleTable(block.getRegistryName().getPath(), block));
    }
}
