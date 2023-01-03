package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStaff extends ItemModRanged {

    protected int damage;

    public ItemStaff(int dam,
                     int arcana) {
        super("bouncing_projectile", null, () -> SoundRegistry.STAFF.get(),
                SoundSource.PLAYERS,
                -1,
                0,
                null,
                arcana);
        this.damage = dam;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaDam(damage));
        tooltip.add(LocalizeUtils.i18n("tooltip.staff.bounce"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        DivineThrowable projectile = new EntityBouncingProjectile((EntityType<? extends EntityBouncingProjectile>) ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, "bouncing_projectile")), player, world, this.damage);
        projectile.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 0.4F);
        world.addFreshEntity(projectile);
    }
}
