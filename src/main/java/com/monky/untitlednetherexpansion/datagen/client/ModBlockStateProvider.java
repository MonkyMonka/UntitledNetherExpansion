package com.monky.untitlednetherexpansion.datagen.client;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {



    public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, UntitledNetherExpansion.MOD_ID, helper);

    }

    @SuppressWarnings( "deprecation" )
    public void buttonBlock(RegistryObject<Block> blockRegistryObject) {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 7);
        ModelFile buttom = models().withExistingParent(name, new ResourceLocation("block/button")).texture("texture", new ResourceLocation(UntitledNetherExpansion.MOD_ID, ("block/" + baseName)));
        ModelFile buttonPressed = models().withExistingParent(name + "_pressed", new ResourceLocation("block/button_pressed")).texture("texture", new ResourceLocation(UntitledNetherExpansion.MOD_ID, ("block/" + baseName)));
        Function<BlockState, ModelFile> modelFunc = $ -> buttom;
        Function<BlockState, ModelFile> pressedModelFunc = $ -> buttonPressed;
        getVariantBuilder(blockRegistryObject.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(s.getValue(BlockStateProperties.POWERED) ? pressedModelFunc.apply(s) : modelFunc.apply(s)).uvLock(s.getValue(BlockStateProperties.ATTACH_FACE).equals(AttachFace.WALL)).rotationX(s.getValue(BlockStateProperties.ATTACH_FACE).ordinal() * 90).rotationY((((int) s.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) + (s.getValue(BlockStateProperties.ATTACH_FACE) == AttachFace.CEILING ? 180 : 0)) % 360).build());
        models().withExistingParent(name + "_inventory", new ResourceLocation("block/button_inventory")).texture("texture", new ResourceLocation(UntitledNetherExpansion.MOD_ID, ("block/" + baseName)));
    }

    @SuppressWarnings( "deprecation" )
    public void pressurePlateBlock(RegistryObject<Block> blockRegistryObject) {
        String name = Registry.BLOCK.getKey(blockRegistryObject.get()).getPath();
        String baseName = name.substring(0, name.length() - 15);
        ModelFile pressurePlateDown = models().withExistingParent(name + "_down", new ResourceLocation("block/pressure_plate_down")).texture("texture", new ResourceLocation(UntitledNetherExpansion.MOD_ID, ("block/" + baseName)));
        ModelFile pressurePlateUp = models().withExistingParent(name + "_up", new ResourceLocation("block/pressure_plate_up")).texture("texture", new ResourceLocation(UntitledNetherExpansion.MOD_ID, ("block/" + baseName)));

        getVariantBuilder(blockRegistryObject.get()).partialState().with(PressurePlateBlock.POWERED, true).modelForState().modelFile(pressurePlateDown).addModel().partialState().with(PressurePlateBlock.POWERED, false).modelForState().modelFile(pressurePlateUp).addModel();
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.MAGNETITE_BLOCK.get());
    }


}


