package com.monky.untitlednetherexpansion.init;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.item.MagneticBandItem;
import com.monky.untitlednetherexpansion.item.MagneticMissileItem;
import com.monky.untitlednetherexpansion.item.VesselItem;
import com.monky.untitlednetherexpansion.item.WayfinderItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            UntitledNetherExpansion.MOD_ID);

    public static final RegistryObject<Item> WAYFINDER_ITEM = register("wayfinder",
            () -> new WayfinderItem(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> DUNKLE_SHELL_ITEM = register("dunkle_shell",
            () -> new Item(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> VESSEL_ITEM = register("vessel",
            () -> new VesselItem(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> MAGNETIC_BAND_ITEM = register("magnetic_band",
            () -> new MagneticBandItem(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.RARE).durability(128)));

    public static final RegistryObject<Item> MAGNETIC_MISSILE_ITEM = register("magnetic_missile",
            () -> new MagneticMissileItem(new Item.Properties().tab(UntitledNetherExpansion.UNTITLEDNETHER_TAB).fireResistant().rarity(Rarity.COMMON)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}

