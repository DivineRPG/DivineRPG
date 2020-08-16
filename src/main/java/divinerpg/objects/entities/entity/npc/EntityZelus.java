package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityZelus extends EntityDivineMerchant {
    public EntityZelus(World world) {
        super(world);
    }
    protected int getGuiId() {
        return GUIHandler.ZELUS_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.zelus.fine",
                "message.zelus.minions",
                "message.zelus.flower",
                "message.zelus.plants"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.fyracryxEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 2), new ItemStack(ItemRegistry.seimerEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 3), new ItemStack(ItemRegistry.paratikuEgg)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.arcanium, 5),
                new ItemStack(ItemRegistry.golemOfRejuvenationEgg)));
        return list;
    }
}