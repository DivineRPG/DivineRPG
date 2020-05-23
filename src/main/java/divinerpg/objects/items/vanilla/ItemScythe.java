package divinerpg.objects.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.enums.BulletType;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.ArmorDescriptionRegistry;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemScythe extends RangedWeaponBase {
    public ItemScythe(String name) {
        super(name,
                null,
                BulletType.SCYTHE_SHOT,
                SoundRegistry.DEEP_LAUGH,
                SoundCategory.MASTER,
                -1,
                0,
                () -> null,
                0);
    }

    @Override
    protected void spawnEntity(World world, EntityPlayer player, ItemStack stack, BulletType bulletType, Class<? extends EntityThrowable> clazz) {
        super.spawnEntity(world, player, stack, isJackoman(player)
                        ? BulletType.MEGA_SCYTHE_SHOT
                        : BulletType.SCYTHE_SHOT,
                null);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.rangedDam(isJackoman(DivineRPG.proxy.getPlayer())
                ? BulletType.MEGA_SCYTHE_SHOT.getDamage()
                : BulletType.SCYTHE_SHOT.getDamage()));

        super.addInformation(stack, worldIn, list, flagIn);
    }

    private boolean isJackoman(EntityPlayer player) {
        if (player == null)
            return false;

        IArmorPowers powers = DivineAPI.getArmorPowers(player);
        if (powers == null)
            return false;

        return powers.wearing(ArmorDescriptionRegistry.JACKOMAN);
    }
}
