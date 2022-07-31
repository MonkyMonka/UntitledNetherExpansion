package com.monky.untitlednetherexpansion.init;
import java.util.function.Function;

import com.google.common.base.Supplier;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.block.MagnetiteBlock;
import com.monky.untitlednetherexpansion.block.WhiskerBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            UntitledNetherExpansion.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> MAGNETITE_BLOCK = register("magnetite",
            () -> new MagnetiteBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(3.0f, 6.0f)
                    .sound(SoundType.COPPER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    public static final RegistryObject<Block> WHISPER_BLOCK = register("whisker",
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

    @Mod.EventBusSubscriber(modid = UntitledNetherExpansion.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientOnly {

        @SubscribeEvent
        public static void setCutoutLayer(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(WHISPER_BLOCK.get(), RenderType.cutoutMipped());
        }
    }
}
