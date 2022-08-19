package com.monky.untitlednetherexpansion.init;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundEventsInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            UntitledNetherExpansion.MOD_ID);

    public static final RegistryObject<SoundEvent> WAYFINDER_CHARGE = register("wayfinder.wayfinder_charge");

    private static RegistryObject<SoundEvent> register(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(UntitledNetherExpansion.MOD_ID, name)));
    }
}
