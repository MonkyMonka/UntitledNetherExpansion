package com.monky.untitlednetherexpansion.datagen.client;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.SoundEventsInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    public ModSoundDefinitionsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

        this.add(SoundEventsInit.WAYFINDER_CHARGE, definition().with(
                sound("untitlednetherexpansion:item/charge_1"),
                sound("untitlednetherexpansion:item/charge_2"),
                sound("untitlednetherexpansion:item/charge_3"),
                sound("untitlednetherexpansion:item/charge_4")
        ).subtitle("subtitles.item.wayfinder_charge"));

        this.add(SoundEventsInit.WAYFINDER_TELEPORT_IN, definition().with(
                sound("untitlednetherexpansion:item/teleport_in_1"),
                sound("untitlednetherexpansion:item/teleport_in_2")
        ).subtitle("subtitles.item.wayfinder_teleport_in"));

        this.add(SoundEventsInit.WAYFINDER_TELEPORT_OUT, definition().with(
                sound("untitlednetherexpansion:item/teleport_out")
        ).subtitle("subtitles.item.wayfinder_teleport_out"));


    }
}
