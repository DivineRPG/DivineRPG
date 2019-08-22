package naturix.divinerpg.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.compat.jei.base.VillagerCategory;
import naturix.divinerpg.compat.jei.base.VillagerWrapper;
import naturix.divinerpg.objects.entities.container.gui.GuiJackOMan;
import naturix.divinerpg.objects.entities.entity.vanilla.JackOMan;

import java.util.stream.Collectors;

@JEIPlugin
public class JEICompat implements IModPlugin {

    // Map<Class, BaseReceipeFactory> categories = new LinkedHashMap<>();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();

        registry.addRecipeCategories(new VillagerCategory(guiHelper,
                GuiJackOMan.MERCHANT_GUI_TEXTURE,
                JeiReferences.JACK_O_MAN_CATEGORY, "Jack O Man"));
    }

    @Override
    public void register(IModRegistry registry) {
        DivineRPG.logger.info("Registering JEI compat");

        registry.addRecipes(JackOMan
                .getAllRecepies()
                .stream()
                .map(VillagerWrapper::new)
                .collect(Collectors.toList()), JeiReferences.JACK_O_MAN_CATEGORY);

    }
}