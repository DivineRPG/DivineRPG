package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityCorruptedBullet;
import divinerpg.items.base.ItemModShotgun;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.List;
public class ItemCorruptedCannon extends ItemModShotgun {
    public ItemCorruptedCannon() {super("corrupted_bullet", null, SoundRegistry.GHAST_CANNON.get(), 0, 15, new ResourceLocation(DivineRPG.MODID, "corrupted_bullet"), 0, 4);}
    @SuppressWarnings("unchecked")
    @Override protected ThrowableProjectile createProjectile(Level world, LivingEntity player) {return new EntityCorruptedBullet((EntityType<? extends ThrowableProjectile>) ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, entityType)), player, world);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDamString("4x10"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}