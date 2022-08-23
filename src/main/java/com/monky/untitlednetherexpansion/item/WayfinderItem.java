package com.monky.untitlednetherexpansion.item;

import com.monky.untitlednetherexpansion.UntitledNetherExpansion;
import com.monky.untitlednetherexpansion.init.ItemInit;
import com.monky.untitlednetherexpansion.init.SoundEventsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundCustomSoundPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CompassItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WayfinderItem extends CompassItem {

    public WayfinderItem(Properties properties) {
        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (isLodestoneCompass(stack)) {
            tooltip.add(new TranslatableComponent("item.untitlednetherexpansion.wayfinder_attuned.desc"));
        }
        else {
            tooltip.add(new TranslatableComponent("item.untitlednetherexpansion.wayfinder_unattuned.desc"));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (!level.getBlockState(blockpos).is(Blocks.LODESTONE)) {
            return super.useOn(pContext);
        } else {
            level.playSound(null, blockpos, SoundEventsInit.WAYFINDER_LOCK.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            Player player = pContext.getPlayer();
            ItemStack itemstack = pContext.getItemInHand();
            boolean flag = !player.getAbilities().instabuild && itemstack.getCount() == 1;
            if (flag) {
                this.addLodestoneTags(level.dimension(), blockpos, itemstack.getOrCreateTag());
            } else {
                ItemStack itemstack1 = new ItemStack(ItemInit.WAYFINDER_ITEM.get(), 1);
                CompoundTag compoundtag = itemstack.hasTag() ? itemstack.getTag().copy() : new CompoundTag();
                itemstack1.setTag(compoundtag);
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                this.addLodestoneTags(level.dimension(), blockpos, compoundtag);
                if (!player.getInventory().add(itemstack1)) {
                    player.drop(itemstack1, false);
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }


    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof ServerPlayer player && isLodestoneCompass(stack)) {
            player.playSound(SoundEventsInit.WAYFINDER_TELEPORT_OUT.get(), 0.5F, 1.0F);
            BlockPos pos = NbtUtils.readBlockPos(stack.getTag().getCompound("LodestonePos"));
            player.teleportTo(player.getLevel(), pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, player.getYRot(), player.getXRot());
            player.connection.send(new ClientboundCustomSoundPacket(SoundEventsInit.WAYFINDER_TELEPORT_IN.get().getLocation(), SoundSource.PLAYERS, player.getPosition(1.0F), 0.5F, 1.0F ));
            player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            stack.shrink(1);

            player.playSound(SoundEventsInit.WAYFINDER_TELEPORT_OUT.get(), 0.5F, 1.0F);
        }
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if (isLodestoneCompass(itemStack)) {
            pPlayer.startUsingItem(pUsedHand);
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEventsInit.WAYFINDER_CHARGE.get(), SoundSource.PLAYERS, 0.5F, 1.0F);
        } else {}
        return super.use(pLevel, pPlayer, pUsedHand);
    }


    private void addLodestoneTags(ResourceKey<Level> pLodestoneDimension, BlockPos pLodestonePos, CompoundTag pCompoundTag) {
        pCompoundTag.put("LodestonePos", NbtUtils.writeBlockPos(pLodestonePos));
        Level.RESOURCE_KEY_CODEC.encodeStart(NbtOps.INSTANCE, pLodestoneDimension).resultOrPartial(UntitledNetherExpansion.LOGGER::error).ifPresent((p_40731_) -> {
            pCompoundTag.put("LodestoneDimension", p_40731_);
        });

        pCompoundTag.putBoolean("LodestoneTracked", true);

        }

    public String getDescriptionId(ItemStack p_40741_) {
        return isLodestoneCompass(p_40741_) ? "Attuned Wayfinder" : super.getDescriptionId(p_40741_);

    }
}