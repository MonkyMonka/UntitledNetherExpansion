package com.monky.untitlednetherexpansion.datagen.client.lang;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

    public ModEnUsProvider(DataGenerator gen) {
        super(gen, UntitledNetherExpansion.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        //Item Groups
        add("itemGroup.untitlednetherexpansion", "Untitled Nether Expansion Tab");

        //Items
        add(ItemInit.WAYFINDER_ITEM.get(), "Wayfinder");

        //Blocks
        add(BlockInit.MAGNETITE_BLOCK.get(), "Magnetite");
        add(BlockInit.CHISELED_MAGNETITE_BLOCK.get(), "Chiseled Magnetite");
        add(BlockInit.POLISHED_MAGNETITE_BLOCK.get(), "Polished Magnetite");
        add(BlockInit.MAGNETITE_BRICK_BLOCK.get(), "Magnetite Bricks");
        add(BlockInit.WHISKER_BLOCK.get(), "Whisker");
    }
}
