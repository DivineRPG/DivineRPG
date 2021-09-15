package divinerpg.items.vanilla;

import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.*;
import java.util.*;

public class ItemScythe extends ItemModRanged {
    public ItemScythe() {
        super("scythe",
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