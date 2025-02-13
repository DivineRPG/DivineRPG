package divinerpg.client.renders.entity.vethea;

import divinerpg.DivineRPG;
import divinerpg.client.models.vethea.ModelInsectFourteen;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vethea.EntityInsectFourteen;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderInsectFourteen extends RenderDivineMob<EntityInsectFourteen> {
    private final ResourceLocation attacking = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/insect_fourteen_attacking.png");
    public RenderInsectFourteen(EntityRendererProvider.Context context) {
        super(context, "insect_fourteen", new ModelInsectFourteen(context), .46F, .75F);
    }
    @Override public ResourceLocation getTextureLocation(EntityInsectFourteen entity) {
        return entity.isAggressive() ? attacking : TEXTURE;
    }
}