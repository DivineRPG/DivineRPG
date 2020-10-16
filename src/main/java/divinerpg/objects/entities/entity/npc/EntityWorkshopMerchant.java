package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.ArmorRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWorkshopMerchant extends EntityDivineMerchant {
    public EntityWorkshopMerchant(World worldIn) {
        super(worldIn);
    }

    protected int getGuiId() {
        return GUIHandler.WORKSHOP_MERCHANT_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.merchant.burr",
                "message.merchant.ho",
                "message.merchant.in",
                "message.merchant.out"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaHelmet, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaChestplate, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaLeggings, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(ArmorRegistry.santaBoots, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.eggNog, 2, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.chocolateLog, 5, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.peppermints, 15, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(ItemRegistry.fruitCake, 3, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 20), new ItemStack(WeaponRegistry.icicleBane, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.greenChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.redChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.blueChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.yellowChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3),
                new ItemStack(BlockRegistry.purpleChristmasLights, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 9), new ItemStack(BlockRegistry.presentBox, 1)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.blueCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.greenCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.pinkCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.redCandyCane, 4)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.iceStone, 3), new ItemStack(BlockRegistry.yellowCandyCane, 4)));
        return list;
    }
}

