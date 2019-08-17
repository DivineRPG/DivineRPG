package naturix.divinerpg.objects.items.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityAttractor;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAttractor extends ItemMod {
    private Random rand = new Random();

    public ItemAttractor() {
        super("arcanium_attractor");
        setCreativeTab(DivineRPGTabs.utility);
        setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = new ItemStack(player.getHeldItemMainhand().getItem());
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);

        if (!world.isRemote && arcana.getArcana() >= 20) {
            world.playSound(player, player.getPosition(), ModSounds.REFLECTOR, SoundCategory.PLAYERS, 1, 1);
            EntityThrowable entity = new EntityAttractor(world, player);
            entity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(entity);
            arcana.consume(player, 20);
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipHelper.getInfoText("tooltip.arcanium_attractor"));
        tooltip.add(TooltipLocalizer.arcanaConsumed(20));
        tooltip.add(TooltipLocalizer.infiniteUses());
    }
}