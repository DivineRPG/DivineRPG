package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.*;
import java.util.*;

public class ItemThrowingStar extends ItemMod {

    public ItemThrowingStar() {
        super();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm"))) {
            tooltip.add(LocalizeUtils.rangedDam(7));
            tooltip.add(LocalizeUtils.i18n("tooltip.vilestorm"));
        }
        if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shuriken"))) {
            tooltip.add(LocalizeUtils.rangedDam(4));
        }
        if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake_shuriken"))) {
            tooltip.add(LocalizeUtils.rangedDam(7));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.MASTER, 1, 1);
        DivineThrowable bullet;
        if (!world.isClientSide) {
            if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm"))) {
                bullet = new EntityVileStorm(EntityRegistry.VILE_STORM.get(), player, world);
            } else if (this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake_shuriken"))) {
                bullet = new EntitySnowflakeShuriken(EntityRegistry.SNOWFLAKE_SHURIKEN.get(), player, world);
            } else {
                bullet = new EntityShuriken(EntityRegistry.SHURIKEN.get(), player, world);
            }
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
        }

        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, itemstack);
    }
}