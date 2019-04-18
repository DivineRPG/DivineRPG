package naturix.divinerpg.utils.models;

import net.minecraft.client.model.ModelRenderer;

public class DivineRenderer extends ModelRenderer {

    public DivineRenderer(DivineModel modelBase, int xOffset, int yOffset) {
        super(modelBase, xOffset, yOffset);
        modelBase.addPart(this);
    }

}
