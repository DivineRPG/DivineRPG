package divinerpg.items.vanilla;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemScythe extends ItemModRanged {
    public ItemScythe() {
        super("scythe",
                RarityList.COMMON,
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
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        super.spawnEntity(world, player, stack, isJackoman(player)
                        ? BulletType.MEGA_SCYTHE_SHOT
                        : BulletType.SCYTHE_SHOT,
                null);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(isJackoman(Minecraft.getInstance().player)
                ? BulletType.MEGA_SCYTHE_SHOT.getDamage()
                : BulletType.SCYTHE_SHOT.getDamage()));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    private boolean isJackoman(PlayerEntity player) {
        if (player == null)
            return false;
        else
            return true;
    }
}