package com.monky.untitlednetherexpansion.datagen.server;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.TagInit;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.minecraft.tags.BlockTags.*;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(TagInit.Blocks.COOL_BLOCKS).add(Blocks.ACACIA_LEAVES).add(BlockInit.WHISKER_BLOCK.get());

        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.POROUS_ROCK_BLOCK.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.MAGNETITE_BLOCK.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.MAGNETITE_BRICK_BLOCK.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.MAGNETITE_BRICK_SLAB.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.MAGNETITE_BRICK_STAIR.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.POLISHED_MAGNETITE_BLOCK.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.POLISHED_MAGNETITE_SLAB.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.POLISHED_MAGNETITE_STAIR.get());
        tag(MINEABLE_WITH_PICKAXE).add(BlockInit.CHISELED_MAGNETITE_BLOCK.get());

        tag(NEEDS_IRON_TOOL).add(BlockInit.MAGNETITE_BLOCK.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.MAGNETITE_BRICK_BLOCK.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.MAGNETITE_BRICK_SLAB.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.MAGNETITE_BRICK_STAIR.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.POLISHED_MAGNETITE_BLOCK.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.POLISHED_MAGNETITE_SLAB.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.POLISHED_MAGNETITE_STAIR.get());
        tag(NEEDS_IRON_TOOL).add(BlockInit.CHISELED_MAGNETITE_BLOCK.get());

        tag(NEEDS_STONE_TOOL).add(BlockInit.POROUS_ROCK_BLOCK.get());


    }
}
