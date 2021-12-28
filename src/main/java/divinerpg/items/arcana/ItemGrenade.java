package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityGrenade;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.List;
import divinerpg.registries.*;
import net.minecraft.stats.*;

public class ItemGrenade extends ItemMod {

    private int counter = 0;

    public ItemGrenade() {
        super("grenade", RarityList.COMMON, DivineRPG.tabs.ranged);

    }

    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        world.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        player.getCooldowns().addCooldown(this, 20);
        if (!world.isClientSide) {
            EntityGrenade grenade = new EntityGrenade(EntityRegistry.GRENADE, world);
            grenade.moveTo(player.getX(), player.getY(), player.getZ());
            grenade.setItem(itemstack);
            grenade.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(grenade);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return ActionResult.sidedSuccess(itemstack, world.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
    }
}
