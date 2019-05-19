package naturix.divinerpg.compat;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEICompat extends BlankModPlugin{

    public static IJeiHelpers jeiHelpers;


    @Override
    public void register(IModRegistry registry) {
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(new ItemStack(ModBlocks.tar));
        
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        super.onRuntimeAvailable(jeiRuntime);

    }
  }