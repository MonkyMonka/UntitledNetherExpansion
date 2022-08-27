package com.monky.untitlednetherexpansion.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MagneticBandItem extends Item {
    public MagneticBandItem(Properties properties) {
    super(properties);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Items.NETHERITE_SCRAP);
    }
}

