package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.arcana.Fyracryx;
import naturix.divinerpg.objects.entities.entity.arcana.GolemOfRejuvenation;
import naturix.divinerpg.objects.entities.entity.arcana.Paratiku;
import naturix.divinerpg.objects.entities.entity.arcana.Seimer;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemZelusSpawnEgg extends ItemMod {

    public ItemZelusSpawnEgg(String name) {
        super(name, DivineRPGTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack stack = player.getHeldItem(hand);
            Item item = stack.getItem();
            int x = pos.getX(), y = pos.getY(), z = pos.getZ();
            if (item == ModItems.fyracryxSpawner) {
                Fyracryx fyracryx = new Fyracryx(world, player);
                fyracryx.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(fyracryx);
            } else if (item == ModItems.seimerSpawner) {
                Seimer seimer = new Seimer(world, player);
                seimer.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(seimer);
            } else if (item == ModItems.golemOfRejuvenationSpawner) {
                GolemOfRejuvenation golem = new GolemOfRejuvenation(world, player);
                golem.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(golem);
            } else if (item == ModItems.paratikuSpawner) {
                Paratiku paratiku = new Paratiku(world, player);
                paratiku.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntity(paratiku);
            }
            stack.shrink(1);
            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        Item item = stack.getItem();
        if (item == ModItems.fyracryxSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.fyracryx_egg"));
        } else if (item == ModItems.seimerSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.seimer_egg"));
        } else if (item == ModItems.golemOfRejuvenationSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.golem_of_rejuvination_egg"));
        } else if (item == ModItems.paratikuSpawner) {
            list.add(TooltipHelper.getInfoText("tooltip.paratiku_egg"));
        }
    }
}