package com.monky.untitlednetherexpansion;

import com.monky.untitlednetherexpansion.init.BlockInit;
import com.monky.untitlednetherexpansion.init.ItemInit;
import com.monky.untitlednetherexpansion.init.SoundEventsInit;
import com.monky.untitlednetherexpansion.item.WayfinderItemProperty;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.world.item.CompassItem.isLodestoneCompass;

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

        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundEventsInit.SOUNDS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ItemProperties.register(ItemInit.WAYFINDER_ITEM.get(),
                    new ResourceLocation(UntitledNetherExpansion.MOD_ID, "attunement"), (stack, level, living, id)  -> {
                        if (isLodestoneCompass(stack)) {
                            return 1.0F;
                        } else {
                            return 0.0F;
                        }
                    });
            ItemProperties.register(ItemInit.WAYFINDER_ITEM.get(),
                    new ResourceLocation("angle"),
                    new WayfinderItemProperty());
                    });
    }
}
