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
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

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
        if(Minecraft.getInstance().player != null)
        tooltip.add(LocalizeUtils.rangedDam(isJackoman(Minecraft.getInstance().player)
                ? BulletType.MEGA_SCYTHE_SHOT.getDamage()
                : BulletType.SCYTHE_SHOT.getDamage()));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    private static Item boots, body = null, legs = null, helmet = null;
    private boolean isJackoman(PlayerEntity player) {

        ItemStack stackBoots = player.inventory.armor.get(0);
        ItemStack stackLegs = player.inventory.armor.get(1);
        ItemStack stackBody = player.inventory.armor.get(2);
        ItemStack stackHelmet = player.inventory.armor.get(3);

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;



        if (boots == ItemRegistry.jackOManBoots && body == ItemRegistry.jackOManChestplate && legs == ItemRegistry.jackOManLeggings && helmet == ItemRegistry.jackOManHelmet) {
            return true;
        }
        else{
            return false;
        }
    }
}