package com.monky.untitlednetherexpansion.datagen.client;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.SoundEventsInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {

    protected ModSoundDefinitionsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

        this.add(SoundEventsInit.WAYFINDER_CHARGE, definition().with(
                sound("untitlednetherexpansion:wayfinder/charge_1"),
                sound("untitlednetherexpansion:wayfinder/charge_2")
        ).subtitle("subtitles.item.wayfinder_charge"));

    }
}
