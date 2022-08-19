package com.monky.untitlednetherexpansion;

import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.ItemInit;
import com.monky.untitlednetherexpansion.init.SoundEventsInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("untitlednetherexpansion")
public class UntitledNetherExpansion {

    public static final String MOD_ID = "untitlednetherexpansion";

    public static final CreativeModeTab UNTITLEDNETHER_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.WAYFINDER_ITEM.get());
        }
    };

    public static final Logger LOGGER = LogManager.getLogger(UntitledNetherExpansion.MOD_ID);


    public UntitledNetherExpansion() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundEventsInit.SOUNDS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
