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

    private void addSubtitle(String category, String subtitleName, String name) {
        add("subtitles." + category + "." + subtitleName, name);
    }

    @Override
    protected void addTranslations() {

        //Item Groups
        add("itemGroup.untitlednetherexpansion", "Untitled Nether Expansion Tab");

        //Items
        add(ItemInit.WAYFINDER_ITEM.get(), "Wayfinder");
        add(ItemInit.WAYFINDER_ITEM.get().getDescriptionId() + "_unattuned.desc", "A inert Wayfinder");
        add(ItemInit.WAYFINDER_ITEM.get().getDescriptionId() + "_attuned.desc", "Instantly teleport to the linked Lodestone upon use");
        add(ItemInit.WAYFINDER_ITEM.get().getDescriptionId() + "_uncharged", "Your wayfinder has not been charged to full");
        add(ItemInit.WAYFINDER_ITEM.get().getDescriptionId() + "_disattuned", "Linked lodestone is missing or destroyed");
        add(ItemInit.DUNKLE_SHELL_ITEM.get(), "Dunkle Shell");
        add(ItemInit.VESSEL_ITEM.get(), "Vessel");
        add(ItemInit.MAGNETIC_BAND_ITEM.get(), "Magnetic Band");
        add(ItemInit.MAGNETIC_MISSILE_ITEM.get(), "Magnetic Missile");


        //Blocks
        add(BlockInit.POROUS_ROCK_BLOCK.get(), "Porous Rock");
        add(BlockInit.MAGNETITE_BLOCK.get(), "Magnetite");
        add(BlockInit.CHISELED_MAGNETITE_BLOCK.get(), "Chiseled Magnetite");
        add(BlockInit.POLISHED_MAGNETITE_BLOCK.get(), "Polished Magnetite");
        add(BlockInit.POLISHED_MAGNETITE_SLAB.get(), "Polished Magnetite Slabs");
        add(BlockInit.POLISHED_MAGNETITE_STAIR.get(), "Polished Magnetite Stairs");
        add(BlockInit.MAGNETITE_BRICK_BLOCK.get(), "Magnetite Bricks");
        add(BlockInit.MAGNETITE_BRICK_SLAB.get(), "Magnetite Brick Slabs");
        add(BlockInit.MAGNETITE_BRICK_STAIR.get(), "Magnetite Brick Stairs");
        add(BlockInit.WHISKER_BLOCK.get(), "Whisker");

        //Sounds
        addSubtitle("item", "wayfinder_charge", "Wayfinder is charged");
        addSubtitle("item", "wayfinder_teleport_in", "Wayfinder used");
        addSubtitle("item", "wayfinder_teleport_out", "Player teleports");
        addSubtitle("item", "wayfinder_lock", "Wayfinder locks onto Lodestone");


    }
}
