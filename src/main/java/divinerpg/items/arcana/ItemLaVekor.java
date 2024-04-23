package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemLaVekor extends ItemModRanged {
    public ItemLaVekor() {super("grenade", BulletType.GRENADE, SoundRegistry.LA_VEKOR.get(), SoundSource.PLAYERS, 0, 0, new ResourceLocation(DivineRPG.MODID, "grenade"), 5);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        EntityShooterBullet bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), player, world, this.bulletType);
        bullet.shootFromRotation(player, player.xRot, player.yRot, 0, 1.5F, 1);
        world.addFreshEntity(bullet);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam((int)bulletType.getDamage()));
        tooltip.add(LocalizeUtils.explosiveShots());
        tooltip.add(LocalizeUtils.ammo(getAmmo()));
        if(!canBeDepleted()) tooltip.add(LocalizeUtils.infiniteUses());
    }
}