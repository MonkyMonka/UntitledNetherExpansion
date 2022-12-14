package com.monky.untitlednetherexpansion.init;
import java.util.function.Function;

import com.google.common.base.Supplier;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.block.MagnetiteBlock;
import com.monky.untitlednetherexpansion.block.PorousRockBlock;
import com.monky.untitlednetherexpansion.block.WhiskerBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            UntitledNetherExpansion.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> POROUS_ROCK_BLOCK = register("porous_rock_block",
            () -> new PorousRockBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.NETHERRACK).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> MAGNETITE_BLOCK = register("magnetite_block",
            () -> new MagnetiteBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> POLISHED_MAGNETITE_BLOCK = register("polished_magnetite_block",
            () -> new MagnetiteBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block>  POLISHED_MAGNETITE_SLAB = register("polished_magnetite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block>  POLISHED_MAGNETITE_STAIR = register("polished_magnetite_stair",
            () -> new StairBlock(() -> BlockInit.POLISHED_MAGNETITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> MAGNETITE_BRICK_BLOCK = register("magnetite_brick_block",
            () -> new MagnetiteBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> MAGNETITE_BRICK_SLAB = register("magnetite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> MAGNETITE_BRICK_STAIR = register("magnetite_brick_stair",
            () -> new StairBlock(() -> BlockInit.MAGNETITE_BRICK_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> CHISELED_MAGNETITE_BLOCK = register("chiseled_magnetite_block",
            () -> new MagnetiteBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> WHISKER_BLOCK = register("whisker_block",
            () -> new WhiskerBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).dynamicShape().sound(SoundType.HANGING_ROOTS)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name,
                                                                     final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }


    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }

}
