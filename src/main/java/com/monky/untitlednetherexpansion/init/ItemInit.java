package com.monky.untitlednetherexpansion.init;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import java.util.function.Supplier;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            UntitledNetherExpansion.MOD_ID);

    public static final RegistryObject<Item> WAYFINDER_ITEM = register("wayfinder",
            () -> new Item(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
