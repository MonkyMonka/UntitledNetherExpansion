package com.monky.untitlednetherexpansion.init;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagInit {
    public static final class Blocks {

        public static final TagKey<Block> COOL_BLOCKS = unexTag("cool_blocks");

        private static TagKey<Block> unexTag(String path) {
            return BlockTags.create(new ResourceLocation(UntitledNetherExpansion.MOD_ID, path));
        }

    }
    public static final class Items {

        public static final TagKey<Item> COOL_ITEMS = unexTag("cool_items");

        private static TagKey<Item> unexTag(String path) {
            return ItemTags.create(new ResourceLocation(UntitledNetherExpansion.MOD_ID, path));
        }

    }
}
