package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModShotgun;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.List;

public class ItemArcaniteBlaster extends ItemModShotgun {
    public ItemArcaniteBlaster() {super("shooter_bullet", BulletType.ARCANITE_BLASTER, SoundRegistry.GHAST_CANNON.get(), 6500, 30, null, 20, 30);}
    @SuppressWarnings("unchecked")
    @Override protected ThrowableProjectile createProjectile(Level world, LivingEntity player) {
    	return new EntityShooterBullet((EntityType<? extends ThrowableProjectile>) ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, this.entityType)), player, world, this.bulletType);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDamString("30x23"));
        tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumedUse));
        tooltip.add(LocalizeUtils.infiniteAmmo());
    }
}