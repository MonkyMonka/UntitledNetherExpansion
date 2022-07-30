package com.monky.untitlednetherexpansion.init;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import java.util.function.Supplier;

import com.monky.untitlednetherexpansion.item.WayfinderItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            UntitledNetherExpansion.MOD_ID);

    public static final RegistryObject<Item> WAYFINDER_ITEM = register("wayfinder",
            () -> new WayfinderItem(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
