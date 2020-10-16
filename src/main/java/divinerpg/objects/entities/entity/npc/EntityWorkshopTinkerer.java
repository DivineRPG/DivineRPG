package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import divinerpg.objects.entities.entity.InfiniteTrade;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.WeaponRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityWorkshopTinkerer extends EntityDivineMerchant {
    public EntityWorkshopTinkerer(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.0F);
    }

    protected int getGuiId() {
        return GUIHandler.WORKSHOP_TINKERER_GUI_ID;
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
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 1), new ItemStack(WeaponRegistry.shuriken, 16, 0),
                new ItemStack(WeaponRegistry.snowflakeShuriken, 16, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 4), new ItemStack(WeaponRegistry.serenadeStriker, 1, 0),
                new ItemStack(WeaponRegistry.serenadeOfIce, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 7), new ItemStack(WeaponRegistry.slimeSword, 1, 0),
                new ItemStack(WeaponRegistry.glacierSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(WeaponRegistry.shadowBow, 1, 0),
                new ItemStack(WeaponRegistry.icicleBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 6), new ItemStack(WeaponRegistry.massivence, 1, 0),
                new ItemStack(WeaponRegistry.frossivence, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(WeaponRegistry.crabclawCannon, 1, 0),
                new ItemStack(WeaponRegistry.frostclawCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 12), new ItemStack(WeaponRegistry.frostCannon, 1, 0),
                new ItemStack(WeaponRegistry.fractiteCannon, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(WeaponRegistry.frostSword, 1, 0),
                new ItemStack(WeaponRegistry.frostkingSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 18), new ItemStack(WeaponRegistry.soundOfMusic, 1, 0),
                new ItemStack(WeaponRegistry.soundOfCarols, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 25), new ItemStack(WeaponRegistry.enderSword, 1, 0),
                new ItemStack(WeaponRegistry.enderice, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 30), new ItemStack(WeaponRegistry.bluefireBow, 1, 0),
                new ItemStack(WeaponRegistry.snowstormBow, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 45), new ItemStack(WeaponRegistry.bedrockMaul, 1, 0),
                new ItemStack(WeaponRegistry.frozenMaul, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 40), new ItemStack(WeaponRegistry.divineSword, 1, 0),
                new ItemStack(WeaponRegistry.icineSword, 1, 0)));
        list.add(new InfiniteTrade(new ItemStack(ItemRegistry.snowflake, 15), new ItemStack(WeaponRegistry.sandslash, 1, 0),
                new ItemStack(WeaponRegistry.snowslash, 1, 0)));
        return list;
    }
}
