package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModThrowable extends ItemMod {
    protected BulletType bulletType;
    public SoundEvent sound;
    public ItemModThrowable(BulletType bulletType) {
        this.bulletType = bulletType;
        sound = SoundEvents.ARROW_SHOOT;
    }
    public ItemModThrowable(Rarity rarity, BulletType bulletType) {
        super(rarity);
        this.bulletType = bulletType;
        sound = SoundEvents.ARROW_SHOOT;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        level.playSound(null, player.blockPosition(), sound != null ? sound : SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, .5F, .4F / (player.getRandom().nextFloat() * .4F + .8F));
        if(!level.isClientSide) {
            EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, level, bulletType);
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
            level.addFreshEntity(bullet);
        } player.awardStat(Stats.ITEM_USED.get(this));
        player.getCooldowns().addCooldown(this, cooldown);
        if(!player.isCreative()) stack.shrink(1);
        return InteractionResultHolder.success(stack);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        if(this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vile_storm"))) {tooltip.add(LocalizeUtils.poison(2));}
        if(this == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "snowflake_shuriken"))) {tooltip.add(LocalizeUtils.slow(2));}
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}