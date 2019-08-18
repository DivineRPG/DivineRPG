package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityMerikMissile;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMeriksMissile extends ItemMod {

    private float arcana = 50;

    public ItemMeriksMissile(String name) {
        super(name, DivineRPGTabs.tools);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entityLiving, int timeLeft) {
        if (stack.getItem() == ModItems.meriksMissile && entityLiving instanceof EntityPlayer) {
            int multiplier = this.getMaxItemUseDuration(stack) - timeLeft;

            EntityPlayer player = (EntityPlayer) entityLiving;

            IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
            if (arcana.getArcana() >= this.arcana && !world.isRemote) {
                float var7 = (float) multiplier / 20.0F;
                var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
                if ((double) var7 < 0.1D)
                    return;

                world.playSound(null,
                        player.getPosition(),
                        ModSounds.VETHEA_BOW,
                        SoundCategory.MASTER,
                        1,
                        1);

                EntityMerikMissile bullet = new EntityMerikMissile(world, player);
                bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(bullet);
                arcana.consume(player, this.arcana);
            }
            }
        }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return Items.BOW.getMaxItemUseDuration(stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Explosive homing projectile");
        list.add(TooltipLocalizer.rangedDam(22));
        list.add(TooltipLocalizer.arcanaConsumed(arcana));
        list.add(TooltipLocalizer.infiniteUses());
    }
}