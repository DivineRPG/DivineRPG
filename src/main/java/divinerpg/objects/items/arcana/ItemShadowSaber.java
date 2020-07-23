package divinerpg.objects.items.arcana;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.objects.items.base.ItemModSword;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemShadowSaber extends ItemModSword {

    public ItemShadowSaber(String name, ToolMaterial mat) {
        super(mat, name);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase hitter) {
        if (hitter instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) hitter;
            IArcana arcana = DivineAPI.getArcana(player);
            if (arcana.getArcana() >= 12) {
                player.playSound(SoundRegistry.SHADOW_SABER, 1, 1);
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 5 * 20, 1));
                arcana.consume(player, 12);
            }
            return true;
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.arcanaConsumed(12));
        list.add(LocalizeUtils.i18n("tooltip.shadow_saber"));
    }
}